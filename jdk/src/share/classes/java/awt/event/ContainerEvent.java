/*
 * Copyright 1996-2007 Sun Microsystems, Inc.  All Rights Reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation.  Sun designates this
 * particular file as subject to the "Classpath" exception as provided
 * by Sun in the LICENSE file that accompanied this code.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * You should have received a copy of the GNU General Public License version
 * 2 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * Please contact Sun Microsystems, Inc., 4150 Network Circle, Santa Clara,
 * CA 95054 USA or visit www.sun.com if you need additional information or
 * have any questions.
 */

package java.awt.event;

import java.awt.Container;
import java.awt.Component;

/**
 * A low-level event which indicates that a container's contents
 * changed because a component was added or removed.
 * <P>
 * Container events are provided for notification purposes ONLY;
 * The AWT will automatically handle changes to the containers
 * contents internally so that the program works properly regardless of
 * whether the program is receiving these events or not.
 * <P>
 * This low-level event is generated by a container object (such as a
 * Panel) when a component is added to it or removed from it.
 * The event is passed to every <code>ContainerListener</code>
 * or <code>ContainerAdapter</code> object which registered to receive such
 * events using the component's <code>addContainerListener</code> method.
 * (<code>ContainerAdapter</code> objects implement the
 * <code>ContainerListener</code> interface.) Each such listener object
 * gets this <code>ContainerEvent</code> when the event occurs.
 * <p>
 * An unspecified behavior will be caused if the {@code id} parameter
 * of any particular {@code ContainerEvent} instance is not
 * in the range from {@code CONTAINER_FIRST} to {@code CONTAINER_LAST}.
 *
 * @see ContainerAdapter
 * @see ContainerListener
 * @see <a href="http://java.sun.com/docs/books/tutorial/post1.0/ui/containerlistener.html">Tutorial: Writing a Container Listener</a>
 *
 * @author Tim Prinzing
 * @author Amy Fowler
 * @since 1.1
 */
public class ContainerEvent extends ComponentEvent {

    /**
     * The first number in the range of ids used for container events.
     */
    public static final int CONTAINER_FIRST             = 300;

    /**
     * The last number in the range of ids used for container events.
     */
    public static final int CONTAINER_LAST              = 301;

   /**
     * This event indicates that a component was added to the container.
     */
    public static final int COMPONENT_ADDED     = CONTAINER_FIRST;

    /**
     * This event indicates that a component was removed from the container.
     */
    public static final int COMPONENT_REMOVED = 1 + CONTAINER_FIRST;

    /**
     * The non-null component that is being added or
     * removed from the Container.
     *
     * @serial
     * @see #getChild()
     */
    Component child;

    /*
     * JDK 1.1 serialVersionUID
     */
    private static final long serialVersionUID = -4114942250539772041L;

    /**
     * Constructs a <code>ContainerEvent</code> object.
     * <p> This method throws an
     * <code>IllegalArgumentException</code> if <code>source</code>
     * is <code>null</code>.
     *
     * @param source The <code>Component</code> object (container)
     *               that originated the event
     * @param id     An integer indicating the type of event.
     *                     For information on allowable values, see
     *                     the class description for {@link ContainerEvent}
     * @param child  the component that was added or removed
     * @throws IllegalArgumentException if <code>source</code> is null
     * @see #getContainer()
     * @see #getID()
     * @see #getChild()
     */
    public ContainerEvent(Component source, int id, Component child) {
        super(source, id);
        this.child = child;
    }

    /**
     * Returns the originator of the event.
     *
     * @return the <code>Container</code> object that originated
     * the event, or <code>null</code> if the object is not a
     * <code>Container</code>.
     */
    public Container getContainer() {
        return (source instanceof Container) ? (Container)source : null;
    }

    /**
     * Returns the component that was affected by the event.
     *
     * @return the Component object that was added or removed
     */
    public Component getChild() {
        return child;
    }

    /**
     * Returns a parameter string identifying this event.
     * This method is useful for event-logging and for debugging.
     *
     * @return a string identifying the event and its attributes
     */
    public String paramString() {
        String typeStr;
        switch(id) {
          case COMPONENT_ADDED:
              typeStr = "COMPONENT_ADDED";
              break;
          case COMPONENT_REMOVED:
              typeStr = "COMPONENT_REMOVED";
              break;
          default:
              typeStr = "unknown type";
        }
        return typeStr + ",child="+child.getName();
    }
}
