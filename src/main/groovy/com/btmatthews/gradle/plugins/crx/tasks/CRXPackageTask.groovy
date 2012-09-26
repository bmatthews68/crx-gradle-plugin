package com.btmatthews.gradle.plugins.crx.tasks;

import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

class CRXPackageTask extends DefaultTask {

    public CRXPackageTask() {
        description = 'Packages and signs Google Chrome Extensions into a .crx package'
    }

    @TaskAction
    def packageCRX() {
    }
}
