package cs113.listGame.enemies;

import cs113.listGame.behaviors.Behavior;
import cs113.listGame.behaviors.MoveToPoint;
import javafx.geometry.Point2D;
import javafx.scene.image.ImageView;
import javafx.scene.shape.MoveTo;

import java.util.ArrayDeque;

public class EnemyDequeStack extends EnemyObject {
    ArrayDeque<Behavior> behaviors = new ArrayDeque<>();

    public EnemyDequeStack(ImageView imageView) { super(imageView); }

    @Override
    public void seedBehaviors() {
        behaviors.add(new MoveToPoint(this, 3000, this.getWorldCenter()));

        Point2D point = new Point2D(this.getWorldCenter().getX(), this.getWorldCenter().getY() - 200);
        behaviors.add(new MoveToPoint(this, 3000, point));
    }

    @Override
    public Behavior getNextBehavior() {
        return behaviors.pollLast();
    }
}
