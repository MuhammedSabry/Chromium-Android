
// Copyright 2014 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

// This file is autogenerated by:
//     mojo/public/tools/bindings/mojom_bindings_generator.py
// For:
//     third_party/WebKit/public/web/remote_objects.mojom
//

package org.chromium.blink.mojom;

import org.chromium.mojo.bindings.DeserializationException;


public final class RemoteInvocationArgument extends org.chromium.mojo.bindings.Union {

    public static final class Tag {
        public static final int NumberValue = 0;
        public static final int BooleanValue = 1;
        public static final int StringValue = 2;
        public static final int SingletonValue = 3;
    };

    private int mTag_ = -1;
    private double mNumberValue;
    private boolean mBooleanValue;
    private org.chromium.mojo_base.mojom.String16 mStringValue;
    private int mSingletonValue;

    public int which() {
      return mTag_;
    }

    public boolean isUnknown() {
      return mTag_ == -1;
    }

    public void setNumberValue(double numberValue) {
        this.mTag_ = Tag.NumberValue;
        this.mNumberValue = numberValue;
    }

    public double getNumberValue() {
        assert this.mTag_ == Tag.NumberValue;
        return this.mNumberValue;
    }

    public void setBooleanValue(boolean booleanValue) {
        this.mTag_ = Tag.BooleanValue;
        this.mBooleanValue = booleanValue;
    }

    public boolean getBooleanValue() {
        assert this.mTag_ == Tag.BooleanValue;
        return this.mBooleanValue;
    }

    public void setStringValue(org.chromium.mojo_base.mojom.String16 stringValue) {
        this.mTag_ = Tag.StringValue;
        this.mStringValue = stringValue;
    }

    public org.chromium.mojo_base.mojom.String16 getStringValue() {
        assert this.mTag_ == Tag.StringValue;
        return this.mStringValue;
    }

    public void setSingletonValue(int singletonValue) {
        this.mTag_ = Tag.SingletonValue;
        this.mSingletonValue = singletonValue;
    }

    public int getSingletonValue() {
        assert this.mTag_ == Tag.SingletonValue;
        return this.mSingletonValue;
    }


    @Override
    protected final void encode(org.chromium.mojo.bindings.Encoder encoder0, int offset) {
        encoder0.encode(org.chromium.mojo.bindings.BindingsHelper.UNION_SIZE, offset);
        encoder0.encode(this.mTag_, offset + 4);
        switch (mTag_) {
            case Tag.NumberValue: {
                
                encoder0.encode(this.mNumberValue, offset + 8);
                break;
            }
            case Tag.BooleanValue: {
                
                encoder0.encode(this.mBooleanValue, offset + 8, 0);
                break;
            }
            case Tag.StringValue: {
                
                encoder0.encode(this.mStringValue, offset + 8, false);
                break;
            }
            case Tag.SingletonValue: {
                
                encoder0.encode(this.mSingletonValue, offset + 8);
                break;
            }
            default: {
                break;
            }
        }
    }

    public static RemoteInvocationArgument deserialize(org.chromium.mojo.bindings.Message message) {
        return decode(new org.chromium.mojo.bindings.Decoder(message).decoderForSerializedUnion(), 0);
    }

    public static final RemoteInvocationArgument decode(org.chromium.mojo.bindings.Decoder decoder0, int offset) {
        org.chromium.mojo.bindings.DataHeader dataHeader = decoder0.readDataHeaderForUnion(offset);
        if (dataHeader.size == 0) {
            return null;
        }
        RemoteInvocationArgument result = new RemoteInvocationArgument();
        switch (dataHeader.elementsOrVersion) {
            case Tag.NumberValue: {
                
                result.mNumberValue = decoder0.readDouble(offset + org.chromium.mojo.bindings.DataHeader.HEADER_SIZE);
                result.mTag_ = Tag.NumberValue;
                break;
            }
            case Tag.BooleanValue: {
                
                result.mBooleanValue = decoder0.readBoolean(offset + org.chromium.mojo.bindings.DataHeader.HEADER_SIZE, 0);
                result.mTag_ = Tag.BooleanValue;
                break;
            }
            case Tag.StringValue: {
                
                org.chromium.mojo.bindings.Decoder decoder1 = decoder0.readPointer(offset + org.chromium.mojo.bindings.DataHeader.HEADER_SIZE, false);
                result.mStringValue = org.chromium.mojo_base.mojom.String16.decode(decoder1);
                result.mTag_ = Tag.StringValue;
                break;
            }
            case Tag.SingletonValue: {
                
                result.mSingletonValue = decoder0.readInt(offset + org.chromium.mojo.bindings.DataHeader.HEADER_SIZE);
                    SingletonJavaScriptValue.validate(result.mSingletonValue);
                result.mTag_ = Tag.SingletonValue;
                break;
            }
            default: {
                break;
            }
        }
        return result;
    }

    /**
     * @see Object#equals(Object)
     */
    @Override
    public boolean equals(Object object) {
        if (object == this)
            return true;
        if (object == null)
            return false;
        if (getClass() != object.getClass())
            return false;
        RemoteInvocationArgument other = (RemoteInvocationArgument) object;
        if (this.mTag_ != other.mTag_)
            return false;
        switch (this.mTag_) {
            case Tag.NumberValue:
                return this.mNumberValue== other.mNumberValue;
            case Tag.BooleanValue:
                return this.mBooleanValue== other.mBooleanValue;
            case Tag.StringValue:
                return org.chromium.mojo.bindings.BindingsHelper.equals(this.mStringValue, other.mStringValue);
            case Tag.SingletonValue:
                return this.mSingletonValue== other.mSingletonValue;
            default:
                break;
        }
        return false;
    }

    /**
     * @see Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = prime + getClass().hashCode();
        result = prime * result + org.chromium.mojo.bindings.BindingsHelper.hashCode(mTag_);
        switch (this.mTag_) {
            case Tag.NumberValue: {
                result = prime * result + org.chromium.mojo.bindings.BindingsHelper.hashCode(this.mNumberValue);
                break;
            }
            case Tag.BooleanValue: {
                result = prime * result + org.chromium.mojo.bindings.BindingsHelper.hashCode(this.mBooleanValue);
                break;
            }
            case Tag.StringValue: {
                result = prime * result + org.chromium.mojo.bindings.BindingsHelper.hashCode(this.mStringValue);
                break;
            }
            case Tag.SingletonValue: {
                result = prime * result + org.chromium.mojo.bindings.BindingsHelper.hashCode(this.mSingletonValue);
                break;
            }
            default: {
                break;
            }
        }
        return result;
    }
}