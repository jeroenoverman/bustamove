package com.group66.game.screencontrollers;

import org.junit.Test;
import org.junit.runner.RunWith;

import de.tomgrill.gdxtesting.GdxTestRunner;

@RunWith(GdxTestRunner.class)
public abstract class AbstractGameControllerTest {
    protected abstract AbstractGameController getGameController();
    
    @Test
    public void pauseTest() {
        AbstractGameController controller = getGameController();
        controller.togglePause();
        controller.update(0);
    }
    
    /*@Test
    public void updateTest() {
        AbstractGameController controller = getGameController();
        controller.update(0);
    }
    
    @Test
    public void winTest() {
        AbstractGameController controller = getGameController();
        try {
            GameManager gameManager = controller.getGameManager1();
            gameManager.getBallManager().checkPop();
        } catch (Exception e) {
            e.printStackTrace();
        }
        controller.update(0);
    }
    
    @Test
    public void loseTest() {
        AbstractGameController controller = getGameController();
        try {
            GameManager gameManager = controller.getGameManager1();
            gameManager.getBallManager().moveRowDown();
            gameManager.getBallManager().moveRowDown();
            gameManager.getBallManager().moveRowDown();
            gameManager.getBallManager().moveRowDown();
            gameManager.getBallManager().moveRowDown();
            gameManager.getBallManager().moveRowDown();
            gameManager.getBallManager().moveRowDown();
            gameManager.getBallManager().moveRowDown();
        } catch (Exception e) {
            e.printStackTrace();
        }
        controller.update(0);
    }*/
}
