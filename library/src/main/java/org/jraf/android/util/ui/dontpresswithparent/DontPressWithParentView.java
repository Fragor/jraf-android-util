/*
 * This source is part of the
 *      _____  ___   ____
 *  __ / / _ \/ _ | / __/___  _______ _
 * / // / , _/ __ |/ _/_/ _ \/ __/ _ `/
 * \___/_/|_/_/ |_/_/ (_)___/_/  \_, /
 *                              /___/
 * repository.
 *
 * Copyright (C) 2013 Benoit 'BoD' Lubek (BoD@JRAF.org)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jraf.android.util.ui.dontpresswithparent;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

/**
 * A view that doesn't propagate its pressed state to its parents.<br/>
 * See <a href="http://cyrilmottier.com/2011/11/23/listview-tips-tricks-4-add-several-clickable-areas/">this article</a> to understand the usefulness of doing
 * this.
 */
public class DontPressWithParentView extends View {

    public DontPressWithParentView(Context context) {
        super(context);
    }

    public DontPressWithParentView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public DontPressWithParentView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    public void setPressed(boolean pressed) {
        if (pressed && getParent() instanceof View && ((View) getParent()).isPressed()) {
            return;
        }
        super.setPressed(pressed);
    }
}
