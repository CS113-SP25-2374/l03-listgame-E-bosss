package cs113.listGame.resources;

import cs113.listGame.gamecore.GameObject;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ResourceLinkedList implements ResourceList {
    LinkedList<ResourceObject> resources = new LinkedList<>();

    @Override
    public void add(ResourceObject resource) {
        resources.addLast(resource);
    }

    @Override
    public void remove(ResourceObject resource) {
        resources.remove(resource);
    }

    @Override
    public void truncate(ResourceObject resource) {
        boolean found = false;

        Iterator<ResourceObject> iterator = resources.iterator();
        while(iterator.hasNext()) {
            if(iterator.next().equals(resource)) {
                found = true;
            }
            if(found) {
                iterator.remove();
            }
        }
    }

    @Override
    public void follow(GameObject leader) {
        Iterator<ResourceObject> iterator = resources.iterator();
        while(iterator.hasNext()) {
            ResourceObject resource = iterator.next();
            resource.moveTowards(leader);
            leader = resource;
        }
    }
}
