package com.github.danthk.myawesomeplugin

import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.actionSystem.CommonDataKeys
import com.intellij.openapi.diagnostic.logger
import com.intellij.openapi.ui.Messages

private val log = logger<PopupDialogAction>()

class PopupDialogAction() : AnAction() {
    override fun actionPerformed(e: AnActionEvent) {
        val currentProject = e.project
        val message = StringBuilder(e.presentation.text + " Selected!")
        val selectedElement = e.getData(CommonDataKeys.NAVIGATABLE)
        if (selectedElement != null) {
            message.append("\nSelected Element: ").append(selectedElement)
        }
        val title = e.presentation.description
        log.info("title: $title")
        Messages.showMessageDialog(
            currentProject,
            message.toString(),
            title,
            Messages.getWarningIcon()
        )
    }
}