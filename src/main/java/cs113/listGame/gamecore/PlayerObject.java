package cs113.listGame.gamecore;

import cs113.listGame.resources.*;
import javafx.geometry.Point2D;
import javafx.scene.image.ImageView;

import java.util.ArrayList;

public class PlayerObject extends GameObject {
    ResourceList resources = new ResourceArrayList();

    public PlayerObject(ImageView imageView, Point2D location) {
        super(imageView);

        setPosition(location);
    }

    @Override
    public void handleCollision(GameObject otherObject) {
        if (otherObject instanceof ResourceObject resourceObject) {
            resources.add(resourceObject);
        }
    }

    public void loseResource(ResourceObject resource) {
        resources.remove(resource);
    }

    public void loseResourceAfter(ResourceObject resource) {
        resources.truncate(resource);
    }

    @Override
    public void update(long now) {
        Point2D cacheDelta = this.delta;
        super.update(now);
        this.delta = cacheDelta;

        resources.follow(this);
    }
}
