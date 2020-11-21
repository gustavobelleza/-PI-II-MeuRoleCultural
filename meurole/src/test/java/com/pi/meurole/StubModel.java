package com.pi.meurole;

import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;

import java.util.Collection;
import java.util.Map;


public class StubModel implements Model {

    private final ModelMap modelMap;

    public StubModel(){
        modelMap = new ModelMap();
    }

    @Override
    public Model addAttribute(String s, Object o) {
        modelMap.addAttribute(s, o);
        return this;
    }

    @Override
    public Model addAttribute(Object o) {
        return null;
    }

    @Override
    public Model addAllAttributes(Collection<?> collection) {
        return null;
    }

    @Override
    public Model addAllAttributes(Map<String, ?> map) {
        return null;
    }

    @Override
    public Model mergeAttributes(Map<String, ?> map) {
        return null;
    }

    @Override
    public boolean containsAttribute(String s) {
        return modelMap.containsAttribute(s);
    }

    @Override
    public Object getAttribute(String s) {
        return modelMap.getAttribute(s);
    }

    @Override
    public Map<String, Object> asMap() {
        return modelMap;
    }
}
