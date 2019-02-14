package com.zfy.main;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.march.common.adapter.JsonAdapter;
import com.march.common.x.LogX;
import com.march.common.x.ToastX;
import com.zfy.component.basic.ComponentX;
import com.zfy.component.basic.app.view.ViewConfig;
import com.zfy.component.basic.mvx.mvp.app.MvpActivity;
import com.zfy.component.biz.Components;
import com.zfy.component.biz.blog.model.BlogModel;
import com.zfy.component.biz.blog.service.BlogService;
import com.zfy.component.biz.common.Keys;
import com.zfy.component.biz.music.model.MusicModel;
import com.zfy.component.biz.music.service.MusicService;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Route(path = Components.MAIN_INDEX_PAGE)
public class MainActivity extends MvpActivity {

    @Override
    public void init() {
        ToastX.show("init");
        clickView(new int[]{
                R.id.blog_page_btn,
                R.id.music_page_btn,
                R.id.blog_service_btn,
                R.id.music_service_btn
        }, view -> {
            if (view.getId() == R.id.blog_page_btn) {
                ComponentX.route(Components.BLOG_INDEX_PAGE)
                        .withString("name", "I am Name")
                        .withInt("age", 100)
                        .withParcelable("model", new BlogModel("传递的 blogModel"))
                        .navigation(getContext());

            } else if (view.getId() == R.id.music_page_btn) {
                ComponentX.route(Components.MUSIC_INDEX_PAGE)
                        .withString(Keys.KEY_TEST, "test")
                        .navigation(getContext());
            } else if (view.getId() == R.id.blog_service_btn) {
                ComponentX.service(BlogService.class, service -> {
                    String blogContent = service.getBlogContent(new BlogModel());
                    ToastX.show(blogContent);
                });
            } else if (view.getId() == R.id.music_service_btn) {
                ComponentX.service(Components.MUSIC_SERVICE, MusicService.class, service -> {
                    service.playMusic(new MusicModel());
                });
                try {
                    test2();
                } catch (Exception e) {
                    e.printStackTrace();
                    LogX.e("chendong", e.getMessage());
                }
            }
        });
    }


    private void test2() {
        Gson gson = new Gson();

        JsonAdapterImpl jsonAdapter = new JsonAdapterImpl();
        List<Data2<Data1>> list = new ArrayList<>();
        list.add(new Data2<>(new Data1("Ssss")));
        String listStr = gson.toJson(list);

        HashMap<String, Data2<Data1>> src = new HashMap<>();
        src.put("aaa", new Data2<>(new Data1("sss")));
        String mapStr = gson.toJson(src);

        HashMap<Integer, Data2<Data1>> intMap = new HashMap<>();
        intMap.put(10000, new Data2<>(new Data1("qqqq")));
        String intMapStr = gson.toJson(intMap);

//        List<Data1> listRst1 = jsonAdapter.toList(listStr, Data1.class);
//        LogX.e("chendong", "1 --> " + listRst1.toString());
//
        List<Data2> listRst2 = jsonAdapter.toList(listStr, Data2.class);
        LogX.e("chendong", "2 --> " + listRst2.toString());
        Data2 data2 = listRst2.get(0); // cast error
        Map data3 = (Map) listRst2.get(0); // ok?

//        Map<String, Data1> mapRst1 = jsonAdapter.toMap(mapStr, String.class, Data1.class);
//        LogX.e("chendong", "3 --> " + mapRst1.toString());

        Map<String, Data2> mapRst2 = jsonAdapter.toMap(mapStr, String.class, Data2.class);
        LogX.e("chendong", "4 --> " + mapRst2.toString());

        Map<Integer, Data2> mapRst4 = jsonAdapter.toMap(intMapStr, Integer.class, Data2.class);
        LogX.e("chendong", "7 --> " + mapRst4.toString());


        Type type = TypeToken.getParameterized(List.class, TypeToken.getParameterized(Data2.class, Data1.class).getType()).getType();
        List<Data2<Data1>> listRst = jsonAdapter.toObj(listStr, type);
        LogX.e("chendong", "41 --> " + listRst.toString());

        Type type1 = TypeToken.getParameterized(Map.class, Integer.class, TypeToken.getParameterized(Data2.class, Data1.class).getType()).getType();
        Map<Integer, Data2> mapRst41 = jsonAdapter.toObj(intMapStr, type1);
        LogX.e("chendong", "71 --> " + mapRst41.toString());
    }

    public class JsonAdapterImpl implements JsonAdapter {
        private Gson mGson = new Gson();

        // obj -> json
        @Override
        public String toJson(Object object) {
            return mGson.toJson(object);
        }

        // json -> obj
        @Override
        public <T> T toObj(String json, Class<T> cls) {
            return mGson.fromJson(json, cls);
        }

        // json -> obj, type 扩展
        @Override
        public <T> T toObj(String json, Type type) {
            return mGson.fromJson(json, type);
        }

        // json -> list
        @Override
        public <T> List<T> toList(String json, Class<T> clazz) {
            return mGson.fromJson(json, TypeToken.getParameterized(List.class, clazz).getType());
        }

        // json -> map
        @Override
        public <K, V> Map<K, V> toMap(String json, Class<K> kClazz, Class<V> vClazz) {
            return mGson.fromJson(json, TypeToken.getParameterized(Map.class, kClazz, vClazz).getType());
        }
    }


    private void test1() {
        Gson gson = new Gson();
        List<Data1> list1 = new ArrayList<>();
        list1.add(new Data1("aaa"));
        list1.add(new Data1("bbb"));
        List<String> listRst1 = gson.fromJson(gson.toJson(list1), new TypeToken<List<Data1>>() {
        }.getType());
        LogX.e("chendong", "1 --> " + listRst1.toString());

        List<Data2<String>> list2 = new ArrayList<>();
        list2.add(new Data2<>("aaa"));
        list2.add(new Data2<>("bbb"));
        List<String> listRst2 = gson.fromJson(gson.toJson(list2), new TypeToken<List<Data2>>() {
        }.getType());
        LogX.e("chendong", "2 --> " + listRst2.toString());

        Map<String, Data1> map1 = new HashMap<>();
        map1.put("aaaa", new Data1("aaa"));
        map1.put("bbb", new Data1("bbb"));
        Map<String, String> mapRst1 = gson.fromJson(gson.toJson(map1), new TypeToken<Map<String, Data1>>() {
        }.getType());
        LogX.e("chendong", mapRst1.toString());

        Map<String, Data2<String>> map2 = new HashMap<>();
        map2.put("aaa", new Data2<>("aaa"));
        map2.put("bbb", new Data2<>("bbb"));
        Map<String, String> mapRst2 = gson.fromJson(gson.toJson(map2), new TypeToken<Map<String, Data2>>() {
        }.getType());
        LogX.e("chendong", mapRst2.toString());
    }

    static class Data1 {

        String name;

        public Data1(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "{data1 name=" + name + "}";
        }
    }


    static class Data2<T> {

        T name;

        List<T> data;

        public Data2(T name) {
            this.name = name;
            data = new ArrayList<>();
            data.add(name);
        }

        @Override
        public String toString() {
            return "Data2{" +
                    "name=" + name +
                    ", data=" + data +
                    '}';
        }
    }

    @Override
    public ViewConfig getViewConfig() {
        return ViewConfig.makeMvp(R.layout.activity_main, null);
    }
}
