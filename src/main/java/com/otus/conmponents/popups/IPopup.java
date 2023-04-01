package com.otus.conmponents.popups;

import com.otus.data.ModalStateData;

public interface IPopup<T> {

    T modalState(ModalStateData modalStateData);
}
