package com.github.amusingimpala75.terrafabriccraftcore.world;

import com.github.amusingimpala75.terrafabriccraftcore.util.DataLayer;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class WorldCacheManager {

    protected Map<String, Float> worldTempCache;

    public WorldCacheManager() {
        worldTempCache = new LinkedHashMap<>();
    }

    public void cleanupCache() {
        while(worldTempCache.size() > 51000) {
            trimTempCache();
        }
    }

    public float getTemp(int x, int z, int totalHours) {
        String key = x+","+z+","+totalHours;
        if(worldTempCache != null && worldTempCache.containsKey(key)) {
            return worldTempCache.get(key);
        }
        return Float.MIN_VALUE;
    }

    public void addTemp(int x, int z, int totalHours, float temp) {
        String key = x+","+z+","+totalHours;
        if(worldTempCache != null) {
            worldTempCache.put(key, temp);
        }
        trimTempCache();
    }

    private void trimTempCache() {
        if(worldTempCache.size() > 50000) {
            Iterator iter = worldTempCache.keySet().iterator();
            if(iter.hasNext()) {
                worldTempCache.remove(iter.next());
            }
        }
    }

}
