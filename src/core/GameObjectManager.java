package core;

import physic.BoxCollider;
import physic.PhysicBody;

import java.awt.*;
import java.util.Vector;

public class GameObjectManager {
    public static GameObjectManager instance = new GameObjectManager();
    private Vector<GameObject> vector = new Vector<>();
    private Vector<GameObject> newVector = new Vector<>();

    //dac diem singleton tao 1 bien static va private ham tao

    private GameObjectManager() {
        this.vector = new Vector<>();
        this.newVector = new Vector<>();
    }

    public void add(GameObject gameObject) {
        newVector.add(gameObject);
    }

    public void runAll() {
        for (GameObject gameObject : vector) {
            if(gameObject.isAlive) {
                gameObject.run();
            }
        }
        vector.addAll(newVector);
        newVector.clear();
    }

    public void renderAll(Graphics graphics) {
        for(GameObject gameObject : vector) {
            if(gameObject.isAlive) {
                gameObject.render(graphics);
            }
        }
    }

    public <T extends GameObject > T checkCollider(BoxCollider boxCollider, Class<T> cls) {
        for(GameObject gameObject : vector) {
            if(!gameObject.isAlive) continue;
            if(!cls.isInstance(gameObject)) continue;
            if(!(gameObject instanceof PhysicBody)) continue;
            BoxCollider other = ((PhysicBody) gameObject).getBoxCollider();
            if(boxCollider.checkBoxCollider(other)) {
                return (T) gameObject;
            }
        }
        return null;
    }

    public <T extends GameObject> T recycle(Class<T> cls) {
        for(GameObject gameObject : vector) {
            if(gameObject.isAlive) continue; // neu square con song thi next
            if(!cls.isInstance(gameObject)) continue;
            gameObject.isAlive = true;
            return (T) gameObject;
        }
        try {
            T instance = cls.newInstance(); //khoi tao object
            this.add(instance);
            return instance;
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
            return null; //ko tao dc thi return null
        }
    }
}
