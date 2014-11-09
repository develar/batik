/*

   Licensed to the Apache Software Foundation (ASF) under one or more
   contributor license agreements.  See the NOTICE file distributed with
   this work for additional information regarding copyright ownership.
   The ASF licenses this file to You under the Apache License, Version 2.0
   (the "License"); you may not use this file except in compliance with
   the License.  You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.

*/

package org.apache.batik.css.engine.value.css2;

import org.apache.batik.css.engine.CSSEngine;
import org.apache.batik.css.engine.value.LengthManager;
import org.apache.batik.css.engine.value.Value;
import org.apache.batik.css.engine.value.ValueConstants;
import org.apache.batik.css.engine.value.ValueManager;
import org.apache.batik.util.SVGTypes;

import org.w3c.css.sac.LexicalUnit;
import org.w3c.dom.DOMException;

/**
 * This class provides a factory for the 'background-padding-*' properties values.
 *
 * @author <a href="mailto:gadams@apache.org">Glenn Adams</a>
 * @version $Id$
 */
public class BackgroundPaddingLengthManager extends LengthManager {

    protected String  prop;

    public BackgroundPaddingLengthManager(String prop) {
        this.prop = prop;
    }
    
    /**
     * Implements {@link ValueManager#isInheritedProperty()}.
     */
    public boolean isInheritedProperty() {
        return false;
    }

    /**
     * Implements {@link ValueManager#isAnimatableProperty()}.
     */
    public boolean isAnimatableProperty() {
        return true;
    }

    /**
     * Implements {@link ValueManager#isAdditiveProperty()}.
     */
    public boolean isAdditiveProperty() {
        return true;
    }

    /**
     * Implements {@link ValueManager#getPropertyType()}.
     */
    public int getPropertyType() {
        return SVGTypes.TYPE_LENGTH_OR_INHERIT;
    }

    /**
     * Implements {@link ValueManager#getPropertyName()}.
     */
    public String getPropertyName() {
        return prop;
    }
    
    /**
     * Implements {@link ValueManager#getDefaultValue()}.
     */
    public Value getDefaultValue() {
        return ValueConstants.NUMBER_0;
    }

    /**
     * Implements {@link ValueManager#createValue(LexicalUnit,CSSEngine)}.
     */
    public Value createValue(LexicalUnit lu, CSSEngine engine)
        throws DOMException {
        if (lu.getLexicalUnitType() == LexicalUnit.SAC_INHERIT) {
            return ValueConstants.INHERIT_VALUE;
        }
        return super.createValue(lu, engine);
    }


    /**
     * Indicates the orientation of the property associated with
     * this manager.
     */
    protected int getOrientation() {
        // background paddings are always wrt to block width, event for top/bottom.
        return HORIZONTAL_ORIENTATION;
    }
}
