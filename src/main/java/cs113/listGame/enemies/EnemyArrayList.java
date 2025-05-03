package cs113.listGame.enemies;

import cs113.listGame.behaviors.Behavior;
import cs113.listGame.behaviors.FollowObject;
import cs113.listGame.behaviors.MoveToPoint;
import cs113.listGame.behaviors.Waiting;
import cs113.listGame.gamecore.GameController;
import javafx.geometry.Point2D;
import javafx.scene.image.ImageView;

import java.util.ArrayList;
import java.util.Random;

public class EnemyArrayList extends EnemyObject {
    ArrayList<Behavior> behaviors = new ArrayList<>();
    Random random = new Random();

    public EnemyArrayList(ImageView imageView) { super(imageView); }

    @Override
    public void seedBehaviors() {
        Point2D dest = new Point2D(random.nextDouble(500), random.nextDouble(400));

        behaviors.add(new MoveToPoint(this, 3000, dest));
        behaviors.add(new Waiting(this, 2000));
        behaviors.add(new Waiting(this, 2000));
        behaviors.add(new FollowObject(this, 3000, GameController.getPlayer()));
        behaviors.add(new MoveToPoint(this, 3000, this.getWorldCenter()));
    }

    @Override
    public Behavior getNextBehavior() {
        if(behaviors.isEmpty()) return null;

        int index = random.nextInt(behaviors.size());
        Behavior behavior = behaviors.get(index);
        behaviors.remove(behavior);
        return behavior;
    }
}