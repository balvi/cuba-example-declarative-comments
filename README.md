[![license](https://img.shields.io/badge/license-Apache%20License%202.0-blue.svg?style=flat)](http://www.apache.org/licenses/LICENSE-2.0)
[![Build Status](https://travis-ci.org/balvi/cuba-component-declarative-controllers.svg?branch=master)](https://travis-ci.org/balvi/cuba-component-declarative-controllers)

# CUBA Platform Example - Declarative Comments

CUBA example that shows how to use the [declarative-controllers application component](https://github.com/balvi/cuba-component-declarative-controllers).


### Customers and Products should be commentable

Let's say you want to add a generic "comments-feature" on entities (in our case you can comment on "Customer" as well as "Product") 
and you already got everything setup on the entity layer. This example shows how to use the declarative-controllers app component to create
a UI where for every controller it should be possible to just declare that this entity should be commentable as well.

For every commentable Entity, there should be a "comments" button in the browse screen:

![Screenshot customer browser](https://github.com/balvi/cuba-example-declarative-comments/blob/master/img/customer-browse.png)

Clicking on the comments for a particular entity, should open a dialog with a list of comments that are associated to this entity:

![Screenshot customer comments](https://github.com/balvi/cuba-example-declarative-comments/blob/master/img/customer-comments.png)

## Using the @Commentable Annotation

This application component brings not only a way of dealing with the inheritance problem. 
It also makes it possible to, instead of programmatically define that certain features should be used, activate these generic features
in a declarative way through the Usage of Annotations.

The [ProductBrowse](https://github.com/balvi/cuba-example-declarative-comments/blob/master/modules/web/src/de/balvi/cuba/example/declarativecomments/web/product/ProductBrowse.java) looks with the declarative definition of the Comments feature:

````
@Commentable(listComponent = "productsTable")
public class ProductBrowse extends AnnotatableAbstractLookup {
}
````

The [CustomerBrowse](https://github.com/balvi/cuba-example-declarative-comments/blob/master/modules/web/src/de/balvi/cuba/example/declarativecomments/web/customer/CustomerBrowse.groovy) looks like this:

````
@Commentable(listComponent = "productsTable")
public class CustomerBrowse extends AnnotatableAbstractLookup {
}
````

## Defining Annotations 

1. Create the [Commentable Annotation](https://github.com/balvi/cuba-example-declarative-comments/blob/master/modules/web/src/de/balvi/cuba/example/declarativecomments/web/commentable/Commentable.java) in your web module like this:


````
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Commentable {
    String listComponent() default "";
    String buttonId() default "commentBtn";
    String buttonsPanel() default "buttonsPanel";
}
````

In this case we need the parameter for the list component it should act on. Additionally it is possible to define what
button should be used. If the button is not available, it will be created (this is sometimes interesting, when you explicitly define where the button should be placed).

2. Create the [CommentableBrowseAnnotationExecutor](https://github.com/balvi/cuba-example-declarative-comments/blob/master/modules/web/src/de/balvi/cuba/example/declarativecomments/web/commentable/CommentableBrowseAnnotationExecutor.groovy) spring bean (in the web module) that implements either `BrowseAnnotationExecutor` 
which contains the logic that sholuld get injected into the controllers:


````
@Component
class CommentableBrowseAnnotationExecutor implements BrowseAnnotationExecutor<Commentable> {

    @Inject
    ButtonsPanelHelper buttonsPanelHelper


    @Override
    void init(Commentable annotation, Window.Lookup browse, Map<String, Object> params) {
        ListComponent listComponent = browse.getComponent(annotation.listComponent()) as ListComponent
        def action = new CommentsButtonAction(listComponent)
        listComponent.addAction(action)
        if (annotation.buttonsPanel()) {
            ButtonsPanel buttonsPanel = browse.getComponent(annotation.buttonsPanel()) as ButtonsPanel
            Button dokumentButton = buttonsPanelHelper.createButton(annotation.buttonId(), buttonsPanel, [])
            dokumentButton.action = action
        }
    }

    @Override
    boolean supports(Annotation annotation) {
        annotation instanceof Commentable
    }


    @Override
    void ready(Commentable annotation, Window.Lookup browse, Map<String, Object> params) {

    }
}
````

The `supports` defines that the Executor should support the Commentable annotation.
In this case we only need the `init` hook method of the browse screen, to add our button.

When the buttons gets clicked it will invoke a [CommentsButtonAction](https://github.com/balvi/cuba-example-declarative-comments/blob/master/modules/web/src/de/balvi/cuba/example/declarativecomments/web/commentable/CommentsButtonAction.groovy) which is just the regular CUBA action programming model:

````
class CommentsButtonAction extends ItemTrackingAction implements Action.HasOpenType {

    WindowManager.OpenType openType

    static final String ACTION_ID = 'commentsAction'


    CommentsButtonAction(ListComponent target) {
        this(ACTION_ID, target)
    }

    CommentsButtonAction(String id, ListComponent target) {
        super(target, id)
        icon = 'font-icon:COMMENTS_O'
        caption = ''
    }

    @Override
    void actionPerform(Component component) {
        def entity = target.singleSelected
        target.frame.openWindow(
                'dbcedc$Comment.browse',
                WindowManager.OpenType.DIALOG,
                [
                        entityId: entity.id,
                        entityClass: entity.metaClass.name,
                        entityInstanceName: entity.instanceName,
                ]
        )
    }

}
````



 