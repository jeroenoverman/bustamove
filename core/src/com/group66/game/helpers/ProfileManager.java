/**
 * 
 */
package com.group66.game.helpers;

import org.json.JSONObject;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.group66.game.BustaMove;
import com.group66.game.logging.MessageType;
import com.group66.game.settings.DynamicSettings;


public class ProfileManager {

    private FileHandle file;

    /**
     * 
     */
    public ProfileManager() {
        
    }

    /**
     * Writes data to json file
     * 
     * @param dynamicSettings the setting to write
     */
    public void writeData(DynamicSettings dynamicSettings) {
        try {
            BustaMove.getGameInstance().log(MessageType.Info, "write profile to memory: " + dynamicSettings.getName());
            file = Gdx.files.external("bustamove/" + dynamicSettings.getName() + ".json");
            JSONObject profile = new JSONObject();
            profile.put("name", dynamicSettings.getName());
            profile.put("currency", dynamicSettings.getCurrency());
            profile.put("scoreMultiplier", dynamicSettings.getScoreMultiplier());
            profile.put("specialBombChanceMultiplier", dynamicSettings.getSpecialBombChanceMultiplier());
            profile.put("ballSpeedMultiplier", dynamicSettings.getBallSpeedMultiplier());
            profile.put("extraLife", dynamicSettings.hasExtraLife());
            profile.put("currentLevel", dynamicSettings.getCurrentLevel());
            profile.put("levelCleared", dynamicSettings.getLevelCleared());
            profile.put("randomLevel", dynamicSettings.isRandomLevel());
            
           
            
            file.writeString(profile.toString(), false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Reads data from memory
     * 
     * @param name of the profile to load
     * @param dynamicSettings settings object where to store.
     */
    public void readData(String name, DynamicSettings dynamicSettings) {
        try {
            BustaMove.getGameInstance().log(MessageType.Info, "Reading profile");
            file = Gdx.files.external("bustamove/" + name + ".json");
            if (!file.exists()) {
                BustaMove.getGameInstance().log(MessageType.Info, "json profile not found");
                return;
            }
            String contents = file.readString();
            JSONObject profile = new JSONObject(contents);
            dynamicSettings.setName(profile.getString("name"), false);
            dynamicSettings.setCurrency(profile.getInt("currency"), false);
            dynamicSettings.setScoreMultiplier(profile.getDouble("scoreMultiplier"), false);
            dynamicSettings.setSpecialBombChanceMultiplier(profile.getDouble("specialBombChanceMultiplier"), false);
            dynamicSettings.setBallSpeedMultiplier(profile.getDouble("ballSpeedMultiplier"), false);
            dynamicSettings.setExtraLife(profile.getBoolean("extraLife"), false);
            dynamicSettings.setCurrentLevel(profile.getInt("currentLevel"), false);
            dynamicSettings.setLevelCleared(profile.getInt("levelCleared"), false);
            dynamicSettings.setRandomLevel(profile.getBoolean("randomLevel"), false);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
