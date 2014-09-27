package com.example.selenium.pagefactorywithanotation;

import org.junit.Test;

/**
 * Created by logarifm on 22.09.14.
 */
public class CodenvyCreateProjectTest extends BaseTest{

    @Test
    public void createSimpleCodenvyProjectBuildAndDelete() {
        driver().get("https://codenvy.com/site/login");

        PF.getCodenvyLoginPage().checkTitle();

        PF.getCodenvyLoginPage().setEmail("logarifm6@meta.ua");

        PF.getCodenvyLoginPage().setPassword("metan");

        PF.getCodenvyLoginPage().logIn();

        PF.getCodenvyIDEPage().checkIDELoaded();

        PF.getCodenvyIDEPage().selectCreateNewProjectInMenyProject();

        PF.getCodenvyIDEPage().checkLaunchOfeXoCreateNewProjectView();

        PF.getCodenvyIDEPage().setProjectName("projectTest2");

        PF.getCodenvyIDEPage().chooseTechnologyProjectJar();

        PF.getCodenvyIDEPage().pressNextButton();

        PF.getCodenvyIDEPage().chooseProjectExample();

        PF.getCodenvyIDEPage().pressFinishButton();

        PF.getCodenvyIDEPage().selectBuildInMenuProject();

        PF.getCodenvyIDEPage().checkSuccessBuildingProject();

        PF.getCodenvyIDEPage().deleteCreatedProject();
    }
}
