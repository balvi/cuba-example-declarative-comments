package de.balvi.cuba.example.declarativecomments.web.commentable

import com.haulmont.cuba.gui.components.Button
import com.haulmont.cuba.gui.components.ButtonsPanel
import com.haulmont.cuba.gui.xml.layout.ComponentsFactory
import groovy.transform.CompileStatic
import org.springframework.stereotype.Component

import javax.inject.Inject

@Component
@CompileStatic
class ButtonsPanelHelper {

    @Inject
    ComponentsFactory componentsFactory

    Button getOrCreateButton(com.haulmont.cuba.gui.components.Component.Container container, String buttonId, String buttonsPanelId) {
        Button button = container.getComponent(buttonId) as Button
        if (buttonsPanelId && !button) {
            ButtonsPanel buttonsPanel = container.getComponent(buttonsPanelId) as ButtonsPanel
            button = createButton(buttonId, buttonsPanel, [])
        }
        button
    }


    Button createButton(String id, ButtonsPanel buttonsPanel, List<String> vorherigeButtonIds) {
        if(!buttonsPanel) {
            return null
        }

        Button button = componentsFactory.createComponent(Button)
        button.id = id

        Integer maxIndex = determineMaxButtonIndex(buttonsPanel, vorherigeButtonIds)
        if(maxIndex != null) {
            buttonsPanel.add(button, maxIndex + 1)
        } else {
            buttonsPanel.add(button)
        }

        button
    }


    private Integer determineMaxButtonIndex(ButtonsPanel buttonsPanel, List<String> buttonIds) {
        buttonsPanel.components.findIndexValues { com.haulmont.cuba.gui.components.Component component ->
            buttonIds.find { component.id?.matches(it) }
        }.max() as Integer
    }

}
