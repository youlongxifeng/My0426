package com.alc.lib_common;

/**
 * @Title:
 * @Description:
 * @author: zou
 * @data: 2021/4/26
 */
public interface Constants {
    interface Router {

        interface Main {
            String F_MAIN = "/main/main";
            String A_MAIN = "/main/MainActivity";
        }
        interface Home {
            String F_MAIN = "/home/main";
            String F_SEARCH = "/home/search";
            String F_RANK = "/home/rank";
            String F_HOT = "/home/hot";
            String F_SEARCH_RESULT = "/home/search/result";
            String F_SEARCH_SUGGEST = "/home/search/suggest";
            String F_ALBUM_LIST = "/home/album/list";
            String F_TRACK_LIST = "/home/track/list";
            String F_ANNOUNCER_LIST = "/home/announcer/list";
            String F_RADIO_LIST = "/home/radio/list";
            String F_ALBUM_DETAIL = "/home/album/detail";
            String F_PLAY_TRACK = "/home/play/track";
            String F_PLAY_RADIIO = "/home/play/radio";
            String F_ANNOUNCER_DETAIL = "/home/announcer/detail";
        }
    }
}
