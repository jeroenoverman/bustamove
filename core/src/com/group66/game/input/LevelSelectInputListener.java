/**
 * 
 */
package com.group66.game.input;

import com.badlogic.gdx.Input.TextInputListener;
import com.group66.game.settings.DynamicSettings;

/**
 * @author Jeroen
 *
 */
public class LevelSelectInputListener implements TextInputListener {
    private DynamicSettings dynamicSettings;
    /**
     * 
     */
    public LevelSelectInputListener(DynamicSettings dynamicSettings) {
        this.dynamicSettings = dynamicSettings;
    }

    /* (non-Javadoc)
     * @see com.badlogic.gdx.Input.TextInputListener#input(java.lang.String)
     */
    @Override
    public void input(String text) {
        int level = Integer.parseInt(text);
        if (level <= dynamicSettings.getLevelCleared()) {
            dynamicSettings.setCurrentLevel(level);
        }

    }

    /* (non-Javadoc)
     * @see com.badlogic.gdx.Input.TextInputListener#canceled()
     */
    @Override
    public void canceled() {
        // TODO Auto-generated method stub

    }

}
