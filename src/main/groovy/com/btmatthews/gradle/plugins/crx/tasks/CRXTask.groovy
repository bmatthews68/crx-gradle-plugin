package com.btmatthews.gradle.plugins.crx.tasks;


import com.btmatthews.gradle.plugins.crx.CRXArchive
import org.gradle.api.DefaultTask
import org.gradle.api.tasks.TaskAction

import java.util.zip.ZipEntry
import java.util.zip.ZipOutputStream

/**
 * @author <a href="mailto:brian@btmatthews.com">Brian Matthews</a>
 */
class CRXTask extends DefaultTask {

    public CRXTask() {
        description = 'Packages and signs Google Chrome Extensions into a .crx package'
    }

    @TaskAction
    def packageCRX() {
        def arrayOutputStream = new ByteArrayOutputStream();
        def zipOutput = new ZipOutputStream(arrayOutputStream);
        def rootDir = project.file(project.crx.crxSourceDirectory);
        int rootDirLength = rootDir.absolutePath.length()
        rootDir.eachFileRecurse { file ->
            def relative = file.absolutePath.substring(rootDirLength).replace('\\', '/')
            if (file.isDirectory() && !relative.endsWith('/')) {
                relative += "/"
            }
            ZipEntry entry = new ZipEntry(relative)
            entry.time = file.lastModified()
            zipOutput.putNextEntry(entry)
            if (file.isFile()) {
                zipOutput << new FileInputStream(file)
            }
        }
        zipOutput.close();

        def crxArchive = new CRXArchive(signature: [], data: arrayOutputStream.toByteArray())
        String crxArchiveName = project.getName() + "-" + project.getVersion() + ".crx";
        crxArchive.write(new File(project.getBuildDir(), crxArchiveName));
    }
}
