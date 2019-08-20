package app.controller;

import app.model.Move;
import java.beans.PropertyEditorSupport;

public class MoveEnumConverter extends PropertyEditorSupport {

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        String capitalized = text.toUpperCase();
        setValue(Move.valueOf(capitalized));
    }
}