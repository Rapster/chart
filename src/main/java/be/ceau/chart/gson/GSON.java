package be.ceau.chart.gson;

import be.ceau.chart.color.Color;
import be.ceau.chart.enums.*;
import be.ceau.chart.javascript.JavaScriptFunction;
import be.ceau.chart.objects.OptionalArray;
import be.ceau.chart.options.Legend;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;

import javax.swing.text.html.Option;

public enum GSON {

    INSTANCE;

    private Gson gson;

    GSON() {
        gson = new GsonBuilder()
            .registerTypeAdapter(Color.class, EnumSerializer.INSTANCE)
            .registerTypeAdapter(BorderCapStyle.class, EnumSerializer.INSTANCE)
            .registerTypeAdapter(BorderJoinStyle.class, EnumSerializer.INSTANCE)
            .registerTypeAdapter(BorderSkipped.class, EnumSerializer.INSTANCE)
            .registerTypeAdapter(Easing.class, EnumSerializer.INSTANCE)
            .registerTypeAdapter(Event.class, EnumSerializer.INSTANCE)
            .registerTypeAdapter(FontFamily.class, EnumSerializer.INSTANCE)
            .registerTypeAdapter(FontStyle.class, EnumSerializer.INSTANCE)
            .registerTypeAdapter(HoverMode.class, EnumSerializer.INSTANCE)
            .registerTypeAdapter(PointStyle.class, EnumSerializer.INSTANCE)
            .registerTypeAdapter(ScalesPosition.class, EnumSerializer.INSTANCE)
            .registerTypeAdapter(TitlePosition.class, EnumSerializer.INSTANCE)
            .registerTypeAdapter(Legend.class, EnumSerializer.INSTANCE)
            .registerTypeAdapter(Color.class, EnumSerializer.INSTANCE)
            .registerTypeAdapter(Color.class, new JavaScriptFunction.JavaScriptFunctionSerializer())
            .registerTypeAdapter(OptionalArray.class, new OptionalArray.OptionalArraySerializer())
            .setPrettyPrinting()
            .create();
    }

    public String toJson(Object src) {
        return gson.toJson(src);
    }

    public <T> T fromJson(String json, Class<T> classOfT) throws JsonSyntaxException {
        return gson.fromJson(json, classOfT);
    }
}
