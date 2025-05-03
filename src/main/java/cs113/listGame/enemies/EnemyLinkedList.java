package cs113.listGame.enemies;

import cs113.listGame.behaviors.Behavior;
import cs113.listGame.behaviors.MoveToPoint;
import javafx.geometry.Point2D;
import javafx.scene.image.ImageView;

import java.util.LinkedList;

public class EnemyLinkedList extends EnemyObject {
    LinkedList<Behavior> behaviors = new LinkedList<>();

    public EnemyLinkedList(ImageView imageView) { super(imageView); }

    @Override
    public void seedBehaviors() {
        Point2D point = new Point2D(this.getWorldCenter().getX(), this.getWorldCenter().getY());
        behaviors.addLast(new MoveToPoint(this, 2000, point));
        point = new Point2D(this.getWorldCenter().getX() - 200, this.getWorldCenter().getY());
        behaviors.addLast(new MoveToPoint(this, 2000, point));
        point = new Point2D(this.getWorldCenter().getX(), this.getWorldCenter().getY() - 200);
        behaviors.addLast(new MoveToPoint(this, 2000, point));
        point = new Point2D(this.getWorldCenter().getX() - 200, this.getWorldCenter().getY() - 200);
        behaviors.addLast(new MoveToPoint(this, 2000, point));
    }

    @Override
    public Behavior getNextBehavior() {
        if(behaviors.isEmpty()) return null;
        return behaviors.pop();
    }
}
