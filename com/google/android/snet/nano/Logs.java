package com.google.android.snet.nano;

import android.support.v4.view.MotionEventCompat;
import com.google.android.gms.playlog.PlayLogger.LogSource;
import com.google.protobuf.nano.CodedInputByteBufferNano;
import com.google.protobuf.nano.CodedOutputByteBufferNano;
import com.google.protobuf.nano.ExtendableMessageNano;
import com.google.protobuf.nano.InternalNano;
import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.google.protobuf.nano.MessageNano;
import com.google.protobuf.nano.WireFormatNano;
import java.io.IOException;
import java.util.Arrays;

public interface Logs {
    public static final int CHROME_LINUX_USER_AGENT = 0;
    public static final int HTTPS_URL_CONNECTION = 2;
    public static final int SAFARI_IPHONE_USER_AGENT = 1;
    public static final int SSL_SOCKET = 1;
    public static final int UNKNOWN = 0;

    public static final class AppInfoNormal extends ExtendableMessageNano<AppInfoNormal> {
        private static volatile AppInfoNormal[] _emptyArray;
        public String apkSha256;
        public byte[] apkSha256Bytes;
        public String packageName;
        public String[] signatureSha256;
        public byte[][] signatureSha256Bytes;
        public boolean systemApp;

        public static AppInfoNormal[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new AppInfoNormal[0];
                    }
                }
            }
            return _emptyArray;
        }

        public AppInfoNormal() {
            clear();
        }

        public AppInfoNormal clear() {
            this.packageName = "";
            this.apkSha256 = "";
            this.signatureSha256 = WireFormatNano.EMPTY_STRING_ARRAY;
            this.systemApp = false;
            this.apkSha256Bytes = WireFormatNano.EMPTY_BYTES;
            this.signatureSha256Bytes = WireFormatNano.EMPTY_BYTES_ARRAY;
            this.unknownFieldData = null;
            this.cachedSize = -1;
            return this;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof AppInfoNormal)) {
                return false;
            }
            AppInfoNormal other = (AppInfoNormal) o;
            if (this.packageName == null) {
                if (other.packageName != null) {
                    return false;
                }
            } else if (!this.packageName.equals(other.packageName)) {
                return false;
            }
            if (this.apkSha256 == null) {
                if (other.apkSha256 != null) {
                    return false;
                }
            } else if (!this.apkSha256.equals(other.apkSha256)) {
                return false;
            }
            if (!InternalNano.equals(this.signatureSha256, other.signatureSha256) || this.systemApp != other.systemApp || !Arrays.equals(this.apkSha256Bytes, other.apkSha256Bytes) || !InternalNano.equals(this.signatureSha256Bytes, other.signatureSha256Bytes)) {
                return false;
            }
            if (this.unknownFieldData != null && !this.unknownFieldData.isEmpty()) {
                return this.unknownFieldData.equals(other.unknownFieldData);
            }
            if (other.unknownFieldData == null || other.unknownFieldData.isEmpty()) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int i;
            int i2 = 0;
            int hashCode = (getClass().getName().hashCode() + 527) * 31;
            if (this.packageName == null) {
                i = 0;
            } else {
                i = this.packageName.hashCode();
            }
            hashCode = (hashCode + i) * 31;
            if (this.apkSha256 == null) {
                i = 0;
            } else {
                i = this.apkSha256.hashCode();
            }
            i = (((((((((hashCode + i) * 31) + InternalNano.hashCode(this.signatureSha256)) * 31) + (this.systemApp ? 1231 : 1237)) * 31) + Arrays.hashCode(this.apkSha256Bytes)) * 31) + InternalNano.hashCode(this.signatureSha256Bytes)) * 31;
            if (!(this.unknownFieldData == null || this.unknownFieldData.isEmpty())) {
                i2 = this.unknownFieldData.hashCode();
            }
            return i + i2;
        }

        public void writeTo(CodedOutputByteBufferNano output) throws IOException {
            if (!(this.packageName == null || this.packageName.equals(""))) {
                output.writeString(1, this.packageName);
            }
            if (!(this.apkSha256 == null || this.apkSha256.equals(""))) {
                output.writeString(2, this.apkSha256);
            }
            if (this.signatureSha256 != null && this.signatureSha256.length > 0) {
                for (String element : this.signatureSha256) {
                    if (element != null) {
                        output.writeString(3, element);
                    }
                }
            }
            if (this.systemApp) {
                output.writeBool(4, this.systemApp);
            }
            if (!Arrays.equals(this.apkSha256Bytes, WireFormatNano.EMPTY_BYTES)) {
                output.writeBytes(5, this.apkSha256Bytes);
            }
            if (this.signatureSha256Bytes != null && this.signatureSha256Bytes.length > 0) {
                for (byte[] element2 : this.signatureSha256Bytes) {
                    if (element2 != null) {
                        output.writeBytes(6, element2);
                    }
                }
            }
            super.writeTo(output);
        }

        protected int computeSerializedSize() {
            int dataCount;
            int dataSize;
            int size = super.computeSerializedSize();
            if (!(this.packageName == null || this.packageName.equals(""))) {
                size += CodedOutputByteBufferNano.computeStringSize(1, this.packageName);
            }
            if (!(this.apkSha256 == null || this.apkSha256.equals(""))) {
                size += CodedOutputByteBufferNano.computeStringSize(2, this.apkSha256);
            }
            if (this.signatureSha256 != null && this.signatureSha256.length > 0) {
                dataCount = 0;
                dataSize = 0;
                for (String element : this.signatureSha256) {
                    if (element != null) {
                        dataCount++;
                        dataSize += CodedOutputByteBufferNano.computeStringSizeNoTag(element);
                    }
                }
                size = (size + dataSize) + (dataCount * 1);
            }
            if (this.systemApp) {
                size += CodedOutputByteBufferNano.computeBoolSize(4, this.systemApp);
            }
            if (!Arrays.equals(this.apkSha256Bytes, WireFormatNano.EMPTY_BYTES)) {
                size += CodedOutputByteBufferNano.computeBytesSize(5, this.apkSha256Bytes);
            }
            if (this.signatureSha256Bytes == null || this.signatureSha256Bytes.length <= 0) {
                return size;
            }
            dataCount = 0;
            dataSize = 0;
            for (byte[] element2 : this.signatureSha256Bytes) {
                if (element2 != null) {
                    dataCount++;
                    dataSize += CodedOutputByteBufferNano.computeBytesSizeNoTag(element2);
                }
            }
            return (size + dataSize) + (dataCount * 1);
        }

        public AppInfoNormal mergeFrom(CodedInputByteBufferNano input) throws IOException {
            while (true) {
                int tag = input.readTag();
                int arrayLength;
                int i;
                switch (tag) {
                    case 0:
                        break;
                    case 10:
                        this.packageName = input.readString();
                        continue;
                    case 18:
                        this.apkSha256 = input.readString();
                        continue;
                    case LogSource.ANDROID_CAMERA /*26*/:
                        arrayLength = WireFormatNano.getRepeatedFieldArrayLength(input, 26);
                        i = this.signatureSha256 == null ? 0 : this.signatureSha256.length;
                        String[] newArray = new String[(i + arrayLength)];
                        if (i != 0) {
                            System.arraycopy(this.signatureSha256, 0, newArray, 0, i);
                        }
                        while (i < newArray.length - 1) {
                            newArray[i] = input.readString();
                            input.readTag();
                            i++;
                        }
                        newArray[i] = input.readString();
                        this.signatureSha256 = newArray;
                        continue;
                    case 32:
                        this.systemApp = input.readBool();
                        continue;
                    case MotionEventCompat.AXIS_GENERIC_11 /*42*/:
                        this.apkSha256Bytes = input.readBytes();
                        continue;
                    case 50:
                        arrayLength = WireFormatNano.getRepeatedFieldArrayLength(input, 50);
                        i = this.signatureSha256Bytes == null ? 0 : this.signatureSha256Bytes.length;
                        byte[][] newArray2 = new byte[(i + arrayLength)][];
                        if (i != 0) {
                            System.arraycopy(this.signatureSha256Bytes, 0, newArray2, 0, i);
                        }
                        while (i < newArray2.length - 1) {
                            newArray2[i] = input.readBytes();
                            input.readTag();
                            i++;
                        }
                        newArray2[i] = input.readBytes();
                        this.signatureSha256Bytes = newArray2;
                        continue;
                    default:
                        if (!super.storeUnknownField(input, tag)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public static AppInfoNormal parseFrom(byte[] data) throws InvalidProtocolBufferNanoException {
            return (AppInfoNormal) MessageNano.mergeFrom(new AppInfoNormal(), data);
        }

        public static AppInfoNormal parseFrom(CodedInputByteBufferNano input) throws IOException {
            return new AppInfoNormal().mergeFrom(input);
        }
    }

    public static final class AppsList extends ExtendableMessageNano<AppsList> {
        public static final int FULL_LOGGING = 2;
        public static final int NO_LOGGING = 0;
        public static final int SHA256_ONLY = 1;
        private static volatile AppsList[] _emptyArray;
        public AppInfoNormal[] appsInfo;
        public int loggingOptions;
        public boolean reportNonSystemApps;
        public boolean reportSystemApps;

        public static AppsList[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new AppsList[0];
                    }
                }
            }
            return _emptyArray;
        }

        public AppsList() {
            clear();
        }

        public AppsList clear() {
            this.reportSystemApps = false;
            this.reportNonSystemApps = false;
            this.loggingOptions = 0;
            this.appsInfo = AppInfoNormal.emptyArray();
            this.unknownFieldData = null;
            this.cachedSize = -1;
            return this;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof AppsList)) {
                return false;
            }
            AppsList other = (AppsList) o;
            if (this.reportSystemApps != other.reportSystemApps || this.reportNonSystemApps != other.reportNonSystemApps || this.loggingOptions != other.loggingOptions || !InternalNano.equals(this.appsInfo, other.appsInfo)) {
                return false;
            }
            if (this.unknownFieldData != null && !this.unknownFieldData.isEmpty()) {
                return this.unknownFieldData.equals(other.unknownFieldData);
            }
            if (other.unknownFieldData == null || other.unknownFieldData.isEmpty()) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int i = 1231;
            int hashCode = (((getClass().getName().hashCode() + 527) * 31) + (this.reportSystemApps ? 1231 : 1237)) * 31;
            if (!this.reportNonSystemApps) {
                i = 1237;
            }
            i = (((((hashCode + i) * 31) + this.loggingOptions) * 31) + InternalNano.hashCode(this.appsInfo)) * 31;
            if (this.unknownFieldData == null || this.unknownFieldData.isEmpty()) {
                hashCode = 0;
            } else {
                hashCode = this.unknownFieldData.hashCode();
            }
            return i + hashCode;
        }

        public void writeTo(CodedOutputByteBufferNano output) throws IOException {
            if (this.reportSystemApps) {
                output.writeBool(1, this.reportSystemApps);
            }
            if (this.reportNonSystemApps) {
                output.writeBool(2, this.reportNonSystemApps);
            }
            if (this.loggingOptions != 0) {
                output.writeInt32(3, this.loggingOptions);
            }
            if (this.appsInfo != null && this.appsInfo.length > 0) {
                for (AppInfoNormal element : this.appsInfo) {
                    if (element != null) {
                        output.writeMessage(4, element);
                    }
                }
            }
            super.writeTo(output);
        }

        protected int computeSerializedSize() {
            int size = super.computeSerializedSize();
            if (this.reportSystemApps) {
                size += CodedOutputByteBufferNano.computeBoolSize(1, this.reportSystemApps);
            }
            if (this.reportNonSystemApps) {
                size += CodedOutputByteBufferNano.computeBoolSize(2, this.reportNonSystemApps);
            }
            if (this.loggingOptions != 0) {
                size += CodedOutputByteBufferNano.computeInt32Size(3, this.loggingOptions);
            }
            if (this.appsInfo != null && this.appsInfo.length > 0) {
                for (AppInfoNormal element : this.appsInfo) {
                    if (element != null) {
                        size += CodedOutputByteBufferNano.computeMessageSize(4, element);
                    }
                }
            }
            return size;
        }

        public AppsList mergeFrom(CodedInputByteBufferNano input) throws IOException {
            while (true) {
                int tag = input.readTag();
                switch (tag) {
                    case 0:
                        break;
                    case 8:
                        this.reportSystemApps = input.readBool();
                        continue;
                    case 16:
                        this.reportNonSystemApps = input.readBool();
                        continue;
                    case 24:
                        int value = input.readInt32();
                        switch (value) {
                            case 0:
                            case 1:
                            case 2:
                                this.loggingOptions = value;
                                break;
                            default:
                                continue;
                        }
                    case 34:
                        int i;
                        int arrayLength = WireFormatNano.getRepeatedFieldArrayLength(input, 34);
                        if (this.appsInfo == null) {
                            i = 0;
                        } else {
                            i = this.appsInfo.length;
                        }
                        AppInfoNormal[] newArray = new AppInfoNormal[(i + arrayLength)];
                        if (i != 0) {
                            System.arraycopy(this.appsInfo, 0, newArray, 0, i);
                        }
                        while (i < newArray.length - 1) {
                            newArray[i] = new AppInfoNormal();
                            input.readMessage(newArray[i]);
                            input.readTag();
                            i++;
                        }
                        newArray[i] = new AppInfoNormal();
                        input.readMessage(newArray[i]);
                        this.appsInfo = newArray;
                        continue;
                    default:
                        if (!super.storeUnknownField(input, tag)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public static AppsList parseFrom(byte[] data) throws InvalidProtocolBufferNanoException {
            return (AppsList) MessageNano.mergeFrom(new AppsList(), data);
        }

        public static AppsList parseFrom(CodedInputByteBufferNano input) throws IOException {
            return new AppsList().mergeFrom(input);
        }
    }

    public static final class AttestationResult extends ExtendableMessageNano<AttestationResult> {
        private static volatile AttestationResult[] _emptyArray;
        public byte[] certChainSha256;
        public String errorMsg;
        public String jsonData;
        public String signature;
        public int statusCode;

        public static AttestationResult[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new AttestationResult[0];
                    }
                }
            }
            return _emptyArray;
        }

        public AttestationResult() {
            clear();
        }

        public AttestationResult clear() {
            this.statusCode = 0;
            this.certChainSha256 = WireFormatNano.EMPTY_BYTES;
            this.jsonData = "";
            this.signature = "";
            this.errorMsg = "";
            this.unknownFieldData = null;
            this.cachedSize = -1;
            return this;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof AttestationResult)) {
                return false;
            }
            AttestationResult other = (AttestationResult) o;
            if (this.statusCode != other.statusCode || !Arrays.equals(this.certChainSha256, other.certChainSha256)) {
                return false;
            }
            if (this.jsonData == null) {
                if (other.jsonData != null) {
                    return false;
                }
            } else if (!this.jsonData.equals(other.jsonData)) {
                return false;
            }
            if (this.signature == null) {
                if (other.signature != null) {
                    return false;
                }
            } else if (!this.signature.equals(other.signature)) {
                return false;
            }
            if (this.errorMsg == null) {
                if (other.errorMsg != null) {
                    return false;
                }
            } else if (!this.errorMsg.equals(other.errorMsg)) {
                return false;
            }
            if (this.unknownFieldData != null && !this.unknownFieldData.isEmpty()) {
                return this.unknownFieldData.equals(other.unknownFieldData);
            }
            if (other.unknownFieldData == null || other.unknownFieldData.isEmpty()) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int i;
            int i2 = 0;
            int hashCode = (((((getClass().getName().hashCode() + 527) * 31) + this.statusCode) * 31) + Arrays.hashCode(this.certChainSha256)) * 31;
            if (this.jsonData == null) {
                i = 0;
            } else {
                i = this.jsonData.hashCode();
            }
            hashCode = (hashCode + i) * 31;
            if (this.signature == null) {
                i = 0;
            } else {
                i = this.signature.hashCode();
            }
            hashCode = (hashCode + i) * 31;
            if (this.errorMsg == null) {
                i = 0;
            } else {
                i = this.errorMsg.hashCode();
            }
            i = (hashCode + i) * 31;
            if (!(this.unknownFieldData == null || this.unknownFieldData.isEmpty())) {
                i2 = this.unknownFieldData.hashCode();
            }
            return i + i2;
        }

        public void writeTo(CodedOutputByteBufferNano output) throws IOException {
            if (this.statusCode != 0) {
                output.writeInt32(1, this.statusCode);
            }
            if (!Arrays.equals(this.certChainSha256, WireFormatNano.EMPTY_BYTES)) {
                output.writeBytes(2, this.certChainSha256);
            }
            if (!(this.jsonData == null || this.jsonData.equals(""))) {
                output.writeString(3, this.jsonData);
            }
            if (!(this.signature == null || this.signature.equals(""))) {
                output.writeString(4, this.signature);
            }
            if (!(this.errorMsg == null || this.errorMsg.equals(""))) {
                output.writeString(5, this.errorMsg);
            }
            super.writeTo(output);
        }

        protected int computeSerializedSize() {
            int size = super.computeSerializedSize();
            if (this.statusCode != 0) {
                size += CodedOutputByteBufferNano.computeInt32Size(1, this.statusCode);
            }
            if (!Arrays.equals(this.certChainSha256, WireFormatNano.EMPTY_BYTES)) {
                size += CodedOutputByteBufferNano.computeBytesSize(2, this.certChainSha256);
            }
            if (!(this.jsonData == null || this.jsonData.equals(""))) {
                size += CodedOutputByteBufferNano.computeStringSize(3, this.jsonData);
            }
            if (!(this.signature == null || this.signature.equals(""))) {
                size += CodedOutputByteBufferNano.computeStringSize(4, this.signature);
            }
            if (this.errorMsg == null || this.errorMsg.equals("")) {
                return size;
            }
            return size + CodedOutputByteBufferNano.computeStringSize(5, this.errorMsg);
        }

        public AttestationResult mergeFrom(CodedInputByteBufferNano input) throws IOException {
            while (true) {
                int tag = input.readTag();
                switch (tag) {
                    case 0:
                        break;
                    case 8:
                        this.statusCode = input.readInt32();
                        continue;
                    case 18:
                        this.certChainSha256 = input.readBytes();
                        continue;
                    case LogSource.ANDROID_CAMERA /*26*/:
                        this.jsonData = input.readString();
                        continue;
                    case 34:
                        this.signature = input.readString();
                        continue;
                    case MotionEventCompat.AXIS_GENERIC_11 /*42*/:
                        this.errorMsg = input.readString();
                        continue;
                    default:
                        if (!super.storeUnknownField(input, tag)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public static AttestationResult parseFrom(byte[] data) throws InvalidProtocolBufferNanoException {
            return (AttestationResult) MessageNano.mergeFrom(new AttestationResult(), data);
        }

        public static AttestationResult parseFrom(CodedInputByteBufferNano input) throws IOException {
            return new AttestationResult().mergeFrom(input);
        }
    }

    public static final class CaptivePortalTestResults extends ExtendableMessageNano<CaptivePortalTestResults> {
        private static volatile CaptivePortalTestResults[] _emptyArray;
        public boolean bodyEmpty;
        public String ipAddressUsed;
        public int responseCode;
        public int userAgentUsed;

        public static CaptivePortalTestResults[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new CaptivePortalTestResults[0];
                    }
                }
            }
            return _emptyArray;
        }

        public CaptivePortalTestResults() {
            clear();
        }

        public CaptivePortalTestResults clear() {
            this.ipAddressUsed = "";
            this.responseCode = 0;
            this.bodyEmpty = false;
            this.userAgentUsed = 0;
            this.unknownFieldData = null;
            this.cachedSize = -1;
            return this;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof CaptivePortalTestResults)) {
                return false;
            }
            CaptivePortalTestResults other = (CaptivePortalTestResults) o;
            if (this.ipAddressUsed == null) {
                if (other.ipAddressUsed != null) {
                    return false;
                }
            } else if (!this.ipAddressUsed.equals(other.ipAddressUsed)) {
                return false;
            }
            if (this.responseCode != other.responseCode || this.bodyEmpty != other.bodyEmpty || this.userAgentUsed != other.userAgentUsed) {
                return false;
            }
            if (this.unknownFieldData != null && !this.unknownFieldData.isEmpty()) {
                return this.unknownFieldData.equals(other.unknownFieldData);
            }
            if (other.unknownFieldData == null || other.unknownFieldData.isEmpty()) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int i;
            int i2 = 0;
            int hashCode = (getClass().getName().hashCode() + 527) * 31;
            if (this.ipAddressUsed == null) {
                i = 0;
            } else {
                i = this.ipAddressUsed.hashCode();
            }
            i = (((((((hashCode + i) * 31) + this.responseCode) * 31) + (this.bodyEmpty ? 1231 : 1237)) * 31) + this.userAgentUsed) * 31;
            if (!(this.unknownFieldData == null || this.unknownFieldData.isEmpty())) {
                i2 = this.unknownFieldData.hashCode();
            }
            return i + i2;
        }

        public void writeTo(CodedOutputByteBufferNano output) throws IOException {
            if (!(this.ipAddressUsed == null || this.ipAddressUsed.equals(""))) {
                output.writeString(1, this.ipAddressUsed);
            }
            if (this.responseCode != 0) {
                output.writeInt32(2, this.responseCode);
            }
            if (this.bodyEmpty) {
                output.writeBool(3, this.bodyEmpty);
            }
            if (this.userAgentUsed != 0) {
                output.writeInt32(4, this.userAgentUsed);
            }
            super.writeTo(output);
        }

        protected int computeSerializedSize() {
            int size = super.computeSerializedSize();
            if (!(this.ipAddressUsed == null || this.ipAddressUsed.equals(""))) {
                size += CodedOutputByteBufferNano.computeStringSize(1, this.ipAddressUsed);
            }
            if (this.responseCode != 0) {
                size += CodedOutputByteBufferNano.computeInt32Size(2, this.responseCode);
            }
            if (this.bodyEmpty) {
                size += CodedOutputByteBufferNano.computeBoolSize(3, this.bodyEmpty);
            }
            if (this.userAgentUsed != 0) {
                return size + CodedOutputByteBufferNano.computeInt32Size(4, this.userAgentUsed);
            }
            return size;
        }

        public CaptivePortalTestResults mergeFrom(CodedInputByteBufferNano input) throws IOException {
            while (true) {
                int tag = input.readTag();
                switch (tag) {
                    case 0:
                        break;
                    case 10:
                        this.ipAddressUsed = input.readString();
                        continue;
                    case 16:
                        this.responseCode = input.readInt32();
                        continue;
                    case 24:
                        this.bodyEmpty = input.readBool();
                        continue;
                    case 32:
                        int value = input.readInt32();
                        switch (value) {
                            case 0:
                            case 1:
                                this.userAgentUsed = value;
                                break;
                            default:
                                continue;
                        }
                    default:
                        if (!super.storeUnknownField(input, tag)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public static CaptivePortalTestResults parseFrom(byte[] data) throws InvalidProtocolBufferNanoException {
            return (CaptivePortalTestResults) MessageNano.mergeFrom(new CaptivePortalTestResults(), data);
        }

        public static CaptivePortalTestResults parseFrom(CodedInputByteBufferNano input) throws IOException {
            return new CaptivePortalTestResults().mergeFrom(input);
        }
    }

    public static final class CarrierInfo extends ExtendableMessageNano<CarrierInfo> {
        private static volatile CarrierInfo[] _emptyArray;
        public String carrierName;

        public static CarrierInfo[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new CarrierInfo[0];
                    }
                }
            }
            return _emptyArray;
        }

        public CarrierInfo() {
            clear();
        }

        public CarrierInfo clear() {
            this.carrierName = "";
            this.unknownFieldData = null;
            this.cachedSize = -1;
            return this;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof CarrierInfo)) {
                return false;
            }
            CarrierInfo other = (CarrierInfo) o;
            if (this.carrierName == null) {
                if (other.carrierName != null) {
                    return false;
                }
            } else if (!this.carrierName.equals(other.carrierName)) {
                return false;
            }
            if (this.unknownFieldData != null && !this.unknownFieldData.isEmpty()) {
                return this.unknownFieldData.equals(other.unknownFieldData);
            }
            if (other.unknownFieldData == null || other.unknownFieldData.isEmpty()) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int i;
            int i2 = 0;
            int hashCode = (getClass().getName().hashCode() + 527) * 31;
            if (this.carrierName == null) {
                i = 0;
            } else {
                i = this.carrierName.hashCode();
            }
            i = (hashCode + i) * 31;
            if (!(this.unknownFieldData == null || this.unknownFieldData.isEmpty())) {
                i2 = this.unknownFieldData.hashCode();
            }
            return i + i2;
        }

        public void writeTo(CodedOutputByteBufferNano output) throws IOException {
            if (!(this.carrierName == null || this.carrierName.equals(""))) {
                output.writeString(1, this.carrierName);
            }
            super.writeTo(output);
        }

        protected int computeSerializedSize() {
            int size = super.computeSerializedSize();
            if (this.carrierName == null || this.carrierName.equals("")) {
                return size;
            }
            return size + CodedOutputByteBufferNano.computeStringSize(1, this.carrierName);
        }

        public CarrierInfo mergeFrom(CodedInputByteBufferNano input) throws IOException {
            while (true) {
                int tag = input.readTag();
                switch (tag) {
                    case 0:
                        break;
                    case 10:
                        this.carrierName = input.readString();
                        continue;
                    default:
                        if (!super.storeUnknownField(input, tag)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public static CarrierInfo parseFrom(byte[] data) throws InvalidProtocolBufferNanoException {
            return (CarrierInfo) MessageNano.mergeFrom(new CarrierInfo(), data);
        }

        public static CarrierInfo parseFrom(CodedInputByteBufferNano input) throws IOException {
            return new CarrierInfo().mergeFrom(input);
        }
    }

    public static final class ConnectionInfo extends ExtendableMessageNano<ConnectionInfo> {
        public static final int BLUETOOTH = 7;
        public static final int DUMMY = 8;
        public static final int ETHERNET = 9;
        public static final int MOBILE = 0;
        public static final int MOBILE_DUN = 4;
        public static final int MOBILE_HIPRI = 5;
        public static final int MOBILE_MMS = 2;
        public static final int MOBILE_SUPL = 3;
        public static final int WIFI = 1;
        public static final int WIMAX = 6;
        private static volatile ConnectionInfo[] _emptyArray;
        public int activeConnectionType;
        public int availableNetworkTypes;
        public String[] dnsServers;
        public String operatorName;

        public static ConnectionInfo[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new ConnectionInfo[0];
                    }
                }
            }
            return _emptyArray;
        }

        public ConnectionInfo() {
            clear();
        }

        public ConnectionInfo clear() {
            this.activeConnectionType = 0;
            this.availableNetworkTypes = 0;
            this.operatorName = "";
            this.dnsServers = WireFormatNano.EMPTY_STRING_ARRAY;
            this.unknownFieldData = null;
            this.cachedSize = -1;
            return this;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof ConnectionInfo)) {
                return false;
            }
            ConnectionInfo other = (ConnectionInfo) o;
            if (this.activeConnectionType != other.activeConnectionType || this.availableNetworkTypes != other.availableNetworkTypes) {
                return false;
            }
            if (this.operatorName == null) {
                if (other.operatorName != null) {
                    return false;
                }
            } else if (!this.operatorName.equals(other.operatorName)) {
                return false;
            }
            if (!InternalNano.equals(this.dnsServers, other.dnsServers)) {
                return false;
            }
            if (this.unknownFieldData != null && !this.unknownFieldData.isEmpty()) {
                return this.unknownFieldData.equals(other.unknownFieldData);
            }
            if (other.unknownFieldData == null || other.unknownFieldData.isEmpty()) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int i;
            int i2 = 0;
            int hashCode = (((((getClass().getName().hashCode() + 527) * 31) + this.activeConnectionType) * 31) + this.availableNetworkTypes) * 31;
            if (this.operatorName == null) {
                i = 0;
            } else {
                i = this.operatorName.hashCode();
            }
            i = (((hashCode + i) * 31) + InternalNano.hashCode(this.dnsServers)) * 31;
            if (!(this.unknownFieldData == null || this.unknownFieldData.isEmpty())) {
                i2 = this.unknownFieldData.hashCode();
            }
            return i + i2;
        }

        public void writeTo(CodedOutputByteBufferNano output) throws IOException {
            if (this.activeConnectionType != 0) {
                output.writeInt32(1, this.activeConnectionType);
            }
            if (this.availableNetworkTypes != 0) {
                output.writeInt32(2, this.availableNetworkTypes);
            }
            if (!(this.operatorName == null || this.operatorName.equals(""))) {
                output.writeString(3, this.operatorName);
            }
            if (this.dnsServers != null && this.dnsServers.length > 0) {
                for (String element : this.dnsServers) {
                    if (element != null) {
                        output.writeString(4, element);
                    }
                }
            }
            super.writeTo(output);
        }

        protected int computeSerializedSize() {
            int size = super.computeSerializedSize();
            if (this.activeConnectionType != 0) {
                size += CodedOutputByteBufferNano.computeInt32Size(1, this.activeConnectionType);
            }
            if (this.availableNetworkTypes != 0) {
                size += CodedOutputByteBufferNano.computeInt32Size(2, this.availableNetworkTypes);
            }
            if (!(this.operatorName == null || this.operatorName.equals(""))) {
                size += CodedOutputByteBufferNano.computeStringSize(3, this.operatorName);
            }
            if (this.dnsServers == null || this.dnsServers.length <= 0) {
                return size;
            }
            int dataCount = 0;
            int dataSize = 0;
            for (String element : this.dnsServers) {
                if (element != null) {
                    dataCount++;
                    dataSize += CodedOutputByteBufferNano.computeStringSizeNoTag(element);
                }
            }
            return (size + dataSize) + (dataCount * 1);
        }

        public ConnectionInfo mergeFrom(CodedInputByteBufferNano input) throws IOException {
            while (true) {
                int tag = input.readTag();
                switch (tag) {
                    case 0:
                        break;
                    case 8:
                        int value = input.readInt32();
                        switch (value) {
                            case 0:
                            case 1:
                            case 2:
                            case 3:
                            case 4:
                            case 5:
                            case 6:
                            case 7:
                            case 8:
                            case 9:
                                this.activeConnectionType = value;
                                break;
                            default:
                                continue;
                        }
                    case 16:
                        this.availableNetworkTypes = input.readInt32();
                        continue;
                    case LogSource.ANDROID_CAMERA /*26*/:
                        this.operatorName = input.readString();
                        continue;
                    case 34:
                        int arrayLength = WireFormatNano.getRepeatedFieldArrayLength(input, 34);
                        int i = this.dnsServers == null ? 0 : this.dnsServers.length;
                        String[] newArray = new String[(i + arrayLength)];
                        if (i != 0) {
                            System.arraycopy(this.dnsServers, 0, newArray, 0, i);
                        }
                        while (i < newArray.length - 1) {
                            newArray[i] = input.readString();
                            input.readTag();
                            i++;
                        }
                        newArray[i] = input.readString();
                        this.dnsServers = newArray;
                        continue;
                    default:
                        if (!super.storeUnknownField(input, tag)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public static ConnectionInfo parseFrom(byte[] data) throws InvalidProtocolBufferNanoException {
            return (ConnectionInfo) MessageNano.mergeFrom(new ConnectionInfo(), data);
        }

        public static ConnectionInfo parseFrom(CodedInputByteBufferNano input) throws IOException {
            return new ConnectionInfo().mergeFrom(input);
        }
    }

    public static final class DeviceSettings extends ExtendableMessageNano<DeviceSettings> {
        public static final int ENROLLED = 1;
        public static final int FACE_PATTERN = 5;
        public static final int FACE_PIN = 4;
        public static final int NONE = 0;
        public static final int NOTIFICATION_NONE = 0;
        public static final int NOTIFICATION_PRIVATE = 1;
        public static final int NOTIFICATION_PUBLIC = 2;
        public static final int NOTIFICATION_SECRET = 3;
        public static final int NOT_SUPPORTED = 0;
        public static final int PASSWORD = 6;
        public static final int PATTERN = 3;
        public static final int PIN = 2;
        public static final int SECURE_UNKNOWN = 1;
        public static final int UNENROLLED = 2;
        private static volatile DeviceSettings[] _emptyArray;
        public boolean adbEnabled;
        public int fingerprintStatus;
        public int lockScreenNotificationType;
        public int lockScreenTimeout;
        public int lockScreenType;
        public boolean nonMarketAppsEnabled;
        public boolean smartLockEnabled;
        public boolean smartLockStatusObtained;
        public int storageEncryptionStatus;

        public static DeviceSettings[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new DeviceSettings[0];
                    }
                }
            }
            return _emptyArray;
        }

        public DeviceSettings() {
            clear();
        }

        public DeviceSettings clear() {
            this.adbEnabled = false;
            this.nonMarketAppsEnabled = false;
            this.lockScreenType = 0;
            this.lockScreenTimeout = 0;
            this.lockScreenNotificationType = 0;
            this.smartLockStatusObtained = false;
            this.smartLockEnabled = false;
            this.storageEncryptionStatus = 0;
            this.fingerprintStatus = 0;
            this.unknownFieldData = null;
            this.cachedSize = -1;
            return this;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof DeviceSettings)) {
                return false;
            }
            DeviceSettings other = (DeviceSettings) o;
            if (this.adbEnabled != other.adbEnabled || this.nonMarketAppsEnabled != other.nonMarketAppsEnabled || this.lockScreenType != other.lockScreenType || this.lockScreenTimeout != other.lockScreenTimeout || this.lockScreenNotificationType != other.lockScreenNotificationType || this.smartLockStatusObtained != other.smartLockStatusObtained || this.smartLockEnabled != other.smartLockEnabled || this.storageEncryptionStatus != other.storageEncryptionStatus || this.fingerprintStatus != other.fingerprintStatus) {
                return false;
            }
            if (this.unknownFieldData != null && !this.unknownFieldData.isEmpty()) {
                return this.unknownFieldData.equals(other.unknownFieldData);
            }
            if (other.unknownFieldData == null || other.unknownFieldData.isEmpty()) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int i;
            int i2 = 1231;
            int hashCode = (((getClass().getName().hashCode() + 527) * 31) + (this.adbEnabled ? 1231 : 1237)) * 31;
            if (this.nonMarketAppsEnabled) {
                i = 1231;
            } else {
                i = 1237;
            }
            hashCode = (((((((hashCode + i) * 31) + this.lockScreenType) * 31) + this.lockScreenTimeout) * 31) + this.lockScreenNotificationType) * 31;
            if (this.smartLockStatusObtained) {
                i = 1231;
            } else {
                i = 1237;
            }
            i = (hashCode + i) * 31;
            if (!this.smartLockEnabled) {
                i2 = 1237;
            }
            i2 = (((((i + i2) * 31) + this.storageEncryptionStatus) * 31) + this.fingerprintStatus) * 31;
            if (this.unknownFieldData == null || this.unknownFieldData.isEmpty()) {
                i = 0;
            } else {
                i = this.unknownFieldData.hashCode();
            }
            return i2 + i;
        }

        public void writeTo(CodedOutputByteBufferNano output) throws IOException {
            if (this.adbEnabled) {
                output.writeBool(1, this.adbEnabled);
            }
            if (this.nonMarketAppsEnabled) {
                output.writeBool(2, this.nonMarketAppsEnabled);
            }
            if (this.lockScreenType != 0) {
                output.writeInt32(3, this.lockScreenType);
            }
            if (this.lockScreenTimeout != 0) {
                output.writeInt32(4, this.lockScreenTimeout);
            }
            if (this.lockScreenNotificationType != 0) {
                output.writeInt32(5, this.lockScreenNotificationType);
            }
            if (this.smartLockStatusObtained) {
                output.writeBool(6, this.smartLockStatusObtained);
            }
            if (this.smartLockEnabled) {
                output.writeBool(7, this.smartLockEnabled);
            }
            if (this.storageEncryptionStatus != 0) {
                output.writeInt32(8, this.storageEncryptionStatus);
            }
            if (this.fingerprintStatus != 0) {
                output.writeInt32(9, this.fingerprintStatus);
            }
            super.writeTo(output);
        }

        protected int computeSerializedSize() {
            int size = super.computeSerializedSize();
            if (this.adbEnabled) {
                size += CodedOutputByteBufferNano.computeBoolSize(1, this.adbEnabled);
            }
            if (this.nonMarketAppsEnabled) {
                size += CodedOutputByteBufferNano.computeBoolSize(2, this.nonMarketAppsEnabled);
            }
            if (this.lockScreenType != 0) {
                size += CodedOutputByteBufferNano.computeInt32Size(3, this.lockScreenType);
            }
            if (this.lockScreenTimeout != 0) {
                size += CodedOutputByteBufferNano.computeInt32Size(4, this.lockScreenTimeout);
            }
            if (this.lockScreenNotificationType != 0) {
                size += CodedOutputByteBufferNano.computeInt32Size(5, this.lockScreenNotificationType);
            }
            if (this.smartLockStatusObtained) {
                size += CodedOutputByteBufferNano.computeBoolSize(6, this.smartLockStatusObtained);
            }
            if (this.smartLockEnabled) {
                size += CodedOutputByteBufferNano.computeBoolSize(7, this.smartLockEnabled);
            }
            if (this.storageEncryptionStatus != 0) {
                size += CodedOutputByteBufferNano.computeInt32Size(8, this.storageEncryptionStatus);
            }
            if (this.fingerprintStatus != 0) {
                return size + CodedOutputByteBufferNano.computeInt32Size(9, this.fingerprintStatus);
            }
            return size;
        }

        public DeviceSettings mergeFrom(CodedInputByteBufferNano input) throws IOException {
            while (true) {
                int tag = input.readTag();
                int value;
                switch (tag) {
                    case 0:
                        break;
                    case 8:
                        this.adbEnabled = input.readBool();
                        continue;
                    case 16:
                        this.nonMarketAppsEnabled = input.readBool();
                        continue;
                    case 24:
                        value = input.readInt32();
                        switch (value) {
                            case 0:
                            case 1:
                            case 2:
                            case 3:
                            case 4:
                            case 5:
                            case 6:
                                this.lockScreenType = value;
                                break;
                            default:
                                continue;
                        }
                    case 32:
                        this.lockScreenTimeout = input.readInt32();
                        continue;
                    case 40:
                        value = input.readInt32();
                        switch (value) {
                            case 0:
                            case 1:
                            case 2:
                            case 3:
                                this.lockScreenNotificationType = value;
                                break;
                            default:
                                continue;
                        }
                    case 48:
                        this.smartLockStatusObtained = input.readBool();
                        continue;
                    case 56:
                        this.smartLockEnabled = input.readBool();
                        continue;
                    case 64:
                        this.storageEncryptionStatus = input.readInt32();
                        continue;
                    case 72:
                        value = input.readInt32();
                        switch (value) {
                            case 0:
                            case 1:
                            case 2:
                                this.fingerprintStatus = value;
                                break;
                            default:
                                continue;
                        }
                    default:
                        if (!super.storeUnknownField(input, tag)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public static DeviceSettings parseFrom(byte[] data) throws InvalidProtocolBufferNanoException {
            return (DeviceSettings) MessageNano.mergeFrom(new DeviceSettings(), data);
        }

        public static DeviceSettings parseFrom(CodedInputByteBufferNano input) throws IOException {
            return new DeviceSettings().mergeFrom(input);
        }
    }

    public static final class DeviceStateNormal extends ExtendableMessageNano<DeviceStateNormal> {
        private static volatile DeviceStateNormal[] _emptyArray;
        public String kernelVersion;
        public int oemLocked;
        public int oemUnlockSupported;
        public String productBrand;
        public String productModel;
        public String securityPatchLevel;
        public SystemPropertyNormal[] systemProperty;
        public String verifiedBootState;
        public String verityMode;

        public static DeviceStateNormal[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new DeviceStateNormal[0];
                    }
                }
            }
            return _emptyArray;
        }

        public DeviceStateNormal() {
            clear();
        }

        public DeviceStateNormal clear() {
            this.verifiedBootState = "";
            this.verityMode = "";
            this.oemUnlockSupported = 0;
            this.oemLocked = 0;
            this.securityPatchLevel = "";
            this.productBrand = "";
            this.productModel = "";
            this.kernelVersion = "";
            this.systemProperty = SystemPropertyNormal.emptyArray();
            this.unknownFieldData = null;
            this.cachedSize = -1;
            return this;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof DeviceStateNormal)) {
                return false;
            }
            DeviceStateNormal other = (DeviceStateNormal) o;
            if (this.verifiedBootState == null) {
                if (other.verifiedBootState != null) {
                    return false;
                }
            } else if (!this.verifiedBootState.equals(other.verifiedBootState)) {
                return false;
            }
            if (this.verityMode == null) {
                if (other.verityMode != null) {
                    return false;
                }
            } else if (!this.verityMode.equals(other.verityMode)) {
                return false;
            }
            if (this.oemUnlockSupported != other.oemUnlockSupported || this.oemLocked != other.oemLocked) {
                return false;
            }
            if (this.securityPatchLevel == null) {
                if (other.securityPatchLevel != null) {
                    return false;
                }
            } else if (!this.securityPatchLevel.equals(other.securityPatchLevel)) {
                return false;
            }
            if (this.productBrand == null) {
                if (other.productBrand != null) {
                    return false;
                }
            } else if (!this.productBrand.equals(other.productBrand)) {
                return false;
            }
            if (this.productModel == null) {
                if (other.productModel != null) {
                    return false;
                }
            } else if (!this.productModel.equals(other.productModel)) {
                return false;
            }
            if (this.kernelVersion == null) {
                if (other.kernelVersion != null) {
                    return false;
                }
            } else if (!this.kernelVersion.equals(other.kernelVersion)) {
                return false;
            }
            if (!InternalNano.equals(this.systemProperty, other.systemProperty)) {
                return false;
            }
            if (this.unknownFieldData != null && !this.unknownFieldData.isEmpty()) {
                return this.unknownFieldData.equals(other.unknownFieldData);
            }
            if (other.unknownFieldData == null || other.unknownFieldData.isEmpty()) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int i;
            int i2 = 0;
            int hashCode = (getClass().getName().hashCode() + 527) * 31;
            if (this.verifiedBootState == null) {
                i = 0;
            } else {
                i = this.verifiedBootState.hashCode();
            }
            hashCode = (hashCode + i) * 31;
            if (this.verityMode == null) {
                i = 0;
            } else {
                i = this.verityMode.hashCode();
            }
            hashCode = (((((hashCode + i) * 31) + this.oemUnlockSupported) * 31) + this.oemLocked) * 31;
            if (this.securityPatchLevel == null) {
                i = 0;
            } else {
                i = this.securityPatchLevel.hashCode();
            }
            hashCode = (hashCode + i) * 31;
            if (this.productBrand == null) {
                i = 0;
            } else {
                i = this.productBrand.hashCode();
            }
            hashCode = (hashCode + i) * 31;
            if (this.productModel == null) {
                i = 0;
            } else {
                i = this.productModel.hashCode();
            }
            hashCode = (hashCode + i) * 31;
            if (this.kernelVersion == null) {
                i = 0;
            } else {
                i = this.kernelVersion.hashCode();
            }
            i = (((hashCode + i) * 31) + InternalNano.hashCode(this.systemProperty)) * 31;
            if (!(this.unknownFieldData == null || this.unknownFieldData.isEmpty())) {
                i2 = this.unknownFieldData.hashCode();
            }
            return i + i2;
        }

        public void writeTo(CodedOutputByteBufferNano output) throws IOException {
            if (!(this.verifiedBootState == null || this.verifiedBootState.equals(""))) {
                output.writeString(1, this.verifiedBootState);
            }
            if (!(this.verityMode == null || this.verityMode.equals(""))) {
                output.writeString(2, this.verityMode);
            }
            if (this.oemUnlockSupported != 0) {
                output.writeInt32(3, this.oemUnlockSupported);
            }
            if (this.oemLocked != 0) {
                output.writeInt32(4, this.oemLocked);
            }
            if (!(this.securityPatchLevel == null || this.securityPatchLevel.equals(""))) {
                output.writeString(5, this.securityPatchLevel);
            }
            if (!(this.productBrand == null || this.productBrand.equals(""))) {
                output.writeString(6, this.productBrand);
            }
            if (!(this.productModel == null || this.productModel.equals(""))) {
                output.writeString(7, this.productModel);
            }
            if (!(this.kernelVersion == null || this.kernelVersion.equals(""))) {
                output.writeString(8, this.kernelVersion);
            }
            if (this.systemProperty != null && this.systemProperty.length > 0) {
                for (SystemPropertyNormal element : this.systemProperty) {
                    if (element != null) {
                        output.writeMessage(9, element);
                    }
                }
            }
            super.writeTo(output);
        }

        protected int computeSerializedSize() {
            int size = super.computeSerializedSize();
            if (!(this.verifiedBootState == null || this.verifiedBootState.equals(""))) {
                size += CodedOutputByteBufferNano.computeStringSize(1, this.verifiedBootState);
            }
            if (!(this.verityMode == null || this.verityMode.equals(""))) {
                size += CodedOutputByteBufferNano.computeStringSize(2, this.verityMode);
            }
            if (this.oemUnlockSupported != 0) {
                size += CodedOutputByteBufferNano.computeInt32Size(3, this.oemUnlockSupported);
            }
            if (this.oemLocked != 0) {
                size += CodedOutputByteBufferNano.computeInt32Size(4, this.oemLocked);
            }
            if (!(this.securityPatchLevel == null || this.securityPatchLevel.equals(""))) {
                size += CodedOutputByteBufferNano.computeStringSize(5, this.securityPatchLevel);
            }
            if (!(this.productBrand == null || this.productBrand.equals(""))) {
                size += CodedOutputByteBufferNano.computeStringSize(6, this.productBrand);
            }
            if (!(this.productModel == null || this.productModel.equals(""))) {
                size += CodedOutputByteBufferNano.computeStringSize(7, this.productModel);
            }
            if (!(this.kernelVersion == null || this.kernelVersion.equals(""))) {
                size += CodedOutputByteBufferNano.computeStringSize(8, this.kernelVersion);
            }
            if (this.systemProperty != null && this.systemProperty.length > 0) {
                for (SystemPropertyNormal element : this.systemProperty) {
                    if (element != null) {
                        size += CodedOutputByteBufferNano.computeMessageSize(9, element);
                    }
                }
            }
            return size;
        }

        public DeviceStateNormal mergeFrom(CodedInputByteBufferNano input) throws IOException {
            while (true) {
                int tag = input.readTag();
                switch (tag) {
                    case 0:
                        break;
                    case 10:
                        this.verifiedBootState = input.readString();
                        continue;
                    case 18:
                        this.verityMode = input.readString();
                        continue;
                    case 24:
                        this.oemUnlockSupported = input.readInt32();
                        continue;
                    case 32:
                        this.oemLocked = input.readInt32();
                        continue;
                    case MotionEventCompat.AXIS_GENERIC_11 /*42*/:
                        this.securityPatchLevel = input.readString();
                        continue;
                    case 50:
                        this.productBrand = input.readString();
                        continue;
                    case 58:
                        this.productModel = input.readString();
                        continue;
                    case 66:
                        this.kernelVersion = input.readString();
                        continue;
                    case 74:
                        int i;
                        int arrayLength = WireFormatNano.getRepeatedFieldArrayLength(input, 74);
                        if (this.systemProperty == null) {
                            i = 0;
                        } else {
                            i = this.systemProperty.length;
                        }
                        SystemPropertyNormal[] newArray = new SystemPropertyNormal[(i + arrayLength)];
                        if (i != 0) {
                            System.arraycopy(this.systemProperty, 0, newArray, 0, i);
                        }
                        while (i < newArray.length - 1) {
                            newArray[i] = new SystemPropertyNormal();
                            input.readMessage(newArray[i]);
                            input.readTag();
                            i++;
                        }
                        newArray[i] = new SystemPropertyNormal();
                        input.readMessage(newArray[i]);
                        this.systemProperty = newArray;
                        continue;
                    default:
                        if (!super.storeUnknownField(input, tag)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public static DeviceStateNormal parseFrom(byte[] data) throws InvalidProtocolBufferNanoException {
            return (DeviceStateNormal) MessageNano.mergeFrom(new DeviceStateNormal(), data);
        }

        public static DeviceStateNormal parseFrom(CodedInputByteBufferNano input) throws IOException {
            return new DeviceStateNormal().mergeFrom(input);
        }
    }

    public static final class DnsMxRecord extends ExtendableMessageNano<DnsMxRecord> {
        private static volatile DnsMxRecord[] _emptyArray;
        public String[] mailServerIpAddresses;
        public String mailServerName;

        public static DnsMxRecord[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new DnsMxRecord[0];
                    }
                }
            }
            return _emptyArray;
        }

        public DnsMxRecord() {
            clear();
        }

        public DnsMxRecord clear() {
            this.mailServerName = "";
            this.mailServerIpAddresses = WireFormatNano.EMPTY_STRING_ARRAY;
            this.unknownFieldData = null;
            this.cachedSize = -1;
            return this;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof DnsMxRecord)) {
                return false;
            }
            DnsMxRecord other = (DnsMxRecord) o;
            if (this.mailServerName == null) {
                if (other.mailServerName != null) {
                    return false;
                }
            } else if (!this.mailServerName.equals(other.mailServerName)) {
                return false;
            }
            if (!InternalNano.equals(this.mailServerIpAddresses, other.mailServerIpAddresses)) {
                return false;
            }
            if (this.unknownFieldData != null && !this.unknownFieldData.isEmpty()) {
                return this.unknownFieldData.equals(other.unknownFieldData);
            }
            if (other.unknownFieldData == null || other.unknownFieldData.isEmpty()) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int i;
            int i2 = 0;
            int hashCode = (getClass().getName().hashCode() + 527) * 31;
            if (this.mailServerName == null) {
                i = 0;
            } else {
                i = this.mailServerName.hashCode();
            }
            i = (((hashCode + i) * 31) + InternalNano.hashCode(this.mailServerIpAddresses)) * 31;
            if (!(this.unknownFieldData == null || this.unknownFieldData.isEmpty())) {
                i2 = this.unknownFieldData.hashCode();
            }
            return i + i2;
        }

        public void writeTo(CodedOutputByteBufferNano output) throws IOException {
            if (!(this.mailServerName == null || this.mailServerName.equals(""))) {
                output.writeString(1, this.mailServerName);
            }
            if (this.mailServerIpAddresses != null && this.mailServerIpAddresses.length > 0) {
                for (String element : this.mailServerIpAddresses) {
                    if (element != null) {
                        output.writeString(2, element);
                    }
                }
            }
            super.writeTo(output);
        }

        protected int computeSerializedSize() {
            int size = super.computeSerializedSize();
            if (!(this.mailServerName == null || this.mailServerName.equals(""))) {
                size += CodedOutputByteBufferNano.computeStringSize(1, this.mailServerName);
            }
            if (this.mailServerIpAddresses == null || this.mailServerIpAddresses.length <= 0) {
                return size;
            }
            int dataCount = 0;
            int dataSize = 0;
            for (String element : this.mailServerIpAddresses) {
                if (element != null) {
                    dataCount++;
                    dataSize += CodedOutputByteBufferNano.computeStringSizeNoTag(element);
                }
            }
            return (size + dataSize) + (dataCount * 1);
        }

        public DnsMxRecord mergeFrom(CodedInputByteBufferNano input) throws IOException {
            while (true) {
                int tag = input.readTag();
                switch (tag) {
                    case 0:
                        break;
                    case 10:
                        this.mailServerName = input.readString();
                        continue;
                    case 18:
                        int arrayLength = WireFormatNano.getRepeatedFieldArrayLength(input, 18);
                        int i = this.mailServerIpAddresses == null ? 0 : this.mailServerIpAddresses.length;
                        String[] newArray = new String[(i + arrayLength)];
                        if (i != 0) {
                            System.arraycopy(this.mailServerIpAddresses, 0, newArray, 0, i);
                        }
                        while (i < newArray.length - 1) {
                            newArray[i] = input.readString();
                            input.readTag();
                            i++;
                        }
                        newArray[i] = input.readString();
                        this.mailServerIpAddresses = newArray;
                        continue;
                    default:
                        if (!super.storeUnknownField(input, tag)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public static DnsMxRecord parseFrom(byte[] data) throws InvalidProtocolBufferNanoException {
            return (DnsMxRecord) MessageNano.mergeFrom(new DnsMxRecord(), data);
        }

        public static DnsMxRecord parseFrom(CodedInputByteBufferNano input) throws IOException {
            return new DnsMxRecord().mergeFrom(input);
        }
    }

    public static final class DnsMxRecords extends ExtendableMessageNano<DnsMxRecords> {
        private static volatile DnsMxRecords[] _emptyArray;
        public String dnsServerQueried;
        public String domainName;
        public byte[] rawDnsQueryResponse;
        public DnsMxRecord[] servers;

        public static DnsMxRecords[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new DnsMxRecords[0];
                    }
                }
            }
            return _emptyArray;
        }

        public DnsMxRecords() {
            clear();
        }

        public DnsMxRecords clear() {
            this.domainName = "";
            this.dnsServerQueried = "";
            this.servers = DnsMxRecord.emptyArray();
            this.rawDnsQueryResponse = WireFormatNano.EMPTY_BYTES;
            this.unknownFieldData = null;
            this.cachedSize = -1;
            return this;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof DnsMxRecords)) {
                return false;
            }
            DnsMxRecords other = (DnsMxRecords) o;
            if (this.domainName == null) {
                if (other.domainName != null) {
                    return false;
                }
            } else if (!this.domainName.equals(other.domainName)) {
                return false;
            }
            if (this.dnsServerQueried == null) {
                if (other.dnsServerQueried != null) {
                    return false;
                }
            } else if (!this.dnsServerQueried.equals(other.dnsServerQueried)) {
                return false;
            }
            if (!InternalNano.equals(this.servers, other.servers) || !Arrays.equals(this.rawDnsQueryResponse, other.rawDnsQueryResponse)) {
                return false;
            }
            if (this.unknownFieldData != null && !this.unknownFieldData.isEmpty()) {
                return this.unknownFieldData.equals(other.unknownFieldData);
            }
            if (other.unknownFieldData == null || other.unknownFieldData.isEmpty()) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int i;
            int i2 = 0;
            int hashCode = (getClass().getName().hashCode() + 527) * 31;
            if (this.domainName == null) {
                i = 0;
            } else {
                i = this.domainName.hashCode();
            }
            hashCode = (hashCode + i) * 31;
            if (this.dnsServerQueried == null) {
                i = 0;
            } else {
                i = this.dnsServerQueried.hashCode();
            }
            i = (((((hashCode + i) * 31) + InternalNano.hashCode(this.servers)) * 31) + Arrays.hashCode(this.rawDnsQueryResponse)) * 31;
            if (!(this.unknownFieldData == null || this.unknownFieldData.isEmpty())) {
                i2 = this.unknownFieldData.hashCode();
            }
            return i + i2;
        }

        public void writeTo(CodedOutputByteBufferNano output) throws IOException {
            if (!(this.domainName == null || this.domainName.equals(""))) {
                output.writeString(1, this.domainName);
            }
            if (!(this.dnsServerQueried == null || this.dnsServerQueried.equals(""))) {
                output.writeString(2, this.dnsServerQueried);
            }
            if (this.servers != null && this.servers.length > 0) {
                for (DnsMxRecord element : this.servers) {
                    if (element != null) {
                        output.writeMessage(3, element);
                    }
                }
            }
            if (!Arrays.equals(this.rawDnsQueryResponse, WireFormatNano.EMPTY_BYTES)) {
                output.writeBytes(4, this.rawDnsQueryResponse);
            }
            super.writeTo(output);
        }

        protected int computeSerializedSize() {
            int size = super.computeSerializedSize();
            if (!(this.domainName == null || this.domainName.equals(""))) {
                size += CodedOutputByteBufferNano.computeStringSize(1, this.domainName);
            }
            if (!(this.dnsServerQueried == null || this.dnsServerQueried.equals(""))) {
                size += CodedOutputByteBufferNano.computeStringSize(2, this.dnsServerQueried);
            }
            if (this.servers != null && this.servers.length > 0) {
                for (DnsMxRecord element : this.servers) {
                    if (element != null) {
                        size += CodedOutputByteBufferNano.computeMessageSize(3, element);
                    }
                }
            }
            if (Arrays.equals(this.rawDnsQueryResponse, WireFormatNano.EMPTY_BYTES)) {
                return size;
            }
            return size + CodedOutputByteBufferNano.computeBytesSize(4, this.rawDnsQueryResponse);
        }

        public DnsMxRecords mergeFrom(CodedInputByteBufferNano input) throws IOException {
            while (true) {
                int tag = input.readTag();
                switch (tag) {
                    case 0:
                        break;
                    case 10:
                        this.domainName = input.readString();
                        continue;
                    case 18:
                        this.dnsServerQueried = input.readString();
                        continue;
                    case LogSource.ANDROID_CAMERA /*26*/:
                        int i;
                        int arrayLength = WireFormatNano.getRepeatedFieldArrayLength(input, 26);
                        if (this.servers == null) {
                            i = 0;
                        } else {
                            i = this.servers.length;
                        }
                        DnsMxRecord[] newArray = new DnsMxRecord[(i + arrayLength)];
                        if (i != 0) {
                            System.arraycopy(this.servers, 0, newArray, 0, i);
                        }
                        while (i < newArray.length - 1) {
                            newArray[i] = new DnsMxRecord();
                            input.readMessage(newArray[i]);
                            input.readTag();
                            i++;
                        }
                        newArray[i] = new DnsMxRecord();
                        input.readMessage(newArray[i]);
                        this.servers = newArray;
                        continue;
                    case 34:
                        this.rawDnsQueryResponse = input.readBytes();
                        continue;
                    default:
                        if (!super.storeUnknownField(input, tag)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public static DnsMxRecords parseFrom(byte[] data) throws InvalidProtocolBufferNanoException {
            return (DnsMxRecords) MessageNano.mergeFrom(new DnsMxRecords(), data);
        }

        public static DnsMxRecords parseFrom(CodedInputByteBufferNano input) throws IOException {
            return new DnsMxRecords().mergeFrom(input);
        }
    }

    public static final class EventLogNormal extends ExtendableMessageNano<EventLogNormal> {
        private static volatile EventLogNormal[] _emptyArray;
        public AppInfoNormal[] appInfo;
        public String data;
        public String subTag;
        public int tag;
        public long timeNanos;

        public static EventLogNormal[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new EventLogNormal[0];
                    }
                }
            }
            return _emptyArray;
        }

        public EventLogNormal() {
            clear();
        }

        public EventLogNormal clear() {
            this.tag = 0;
            this.subTag = "";
            this.timeNanos = 0;
            this.appInfo = AppInfoNormal.emptyArray();
            this.data = "";
            this.unknownFieldData = null;
            this.cachedSize = -1;
            return this;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof EventLogNormal)) {
                return false;
            }
            EventLogNormal other = (EventLogNormal) o;
            if (this.tag != other.tag) {
                return false;
            }
            if (this.subTag == null) {
                if (other.subTag != null) {
                    return false;
                }
            } else if (!this.subTag.equals(other.subTag)) {
                return false;
            }
            if (this.timeNanos != other.timeNanos || !InternalNano.equals(this.appInfo, other.appInfo)) {
                return false;
            }
            if (this.data == null) {
                if (other.data != null) {
                    return false;
                }
            } else if (!this.data.equals(other.data)) {
                return false;
            }
            if (this.unknownFieldData != null && !this.unknownFieldData.isEmpty()) {
                return this.unknownFieldData.equals(other.unknownFieldData);
            }
            if (other.unknownFieldData == null || other.unknownFieldData.isEmpty()) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int i;
            int i2 = 0;
            int hashCode = (((getClass().getName().hashCode() + 527) * 31) + this.tag) * 31;
            if (this.subTag == null) {
                i = 0;
            } else {
                i = this.subTag.hashCode();
            }
            hashCode = (((((hashCode + i) * 31) + ((int) (this.timeNanos ^ (this.timeNanos >>> 32)))) * 31) + InternalNano.hashCode(this.appInfo)) * 31;
            if (this.data == null) {
                i = 0;
            } else {
                i = this.data.hashCode();
            }
            i = (hashCode + i) * 31;
            if (!(this.unknownFieldData == null || this.unknownFieldData.isEmpty())) {
                i2 = this.unknownFieldData.hashCode();
            }
            return i + i2;
        }

        public void writeTo(CodedOutputByteBufferNano output) throws IOException {
            if (this.tag != 0) {
                output.writeInt32(1, this.tag);
            }
            if (!(this.subTag == null || this.subTag.equals(""))) {
                output.writeString(2, this.subTag);
            }
            if (this.timeNanos != 0) {
                output.writeInt64(3, this.timeNanos);
            }
            if (this.appInfo != null && this.appInfo.length > 0) {
                for (AppInfoNormal element : this.appInfo) {
                    if (element != null) {
                        output.writeMessage(4, element);
                    }
                }
            }
            if (!(this.data == null || this.data.equals(""))) {
                output.writeString(5, this.data);
            }
            super.writeTo(output);
        }

        protected int computeSerializedSize() {
            int size = super.computeSerializedSize();
            if (this.tag != 0) {
                size += CodedOutputByteBufferNano.computeInt32Size(1, this.tag);
            }
            if (!(this.subTag == null || this.subTag.equals(""))) {
                size += CodedOutputByteBufferNano.computeStringSize(2, this.subTag);
            }
            if (this.timeNanos != 0) {
                size += CodedOutputByteBufferNano.computeInt64Size(3, this.timeNanos);
            }
            if (this.appInfo != null && this.appInfo.length > 0) {
                for (AppInfoNormal element : this.appInfo) {
                    if (element != null) {
                        size += CodedOutputByteBufferNano.computeMessageSize(4, element);
                    }
                }
            }
            if (this.data == null || this.data.equals("")) {
                return size;
            }
            return size + CodedOutputByteBufferNano.computeStringSize(5, this.data);
        }

        public EventLogNormal mergeFrom(CodedInputByteBufferNano input) throws IOException {
            while (true) {
                int tag = input.readTag();
                switch (tag) {
                    case 0:
                        break;
                    case 8:
                        this.tag = input.readInt32();
                        continue;
                    case 18:
                        this.subTag = input.readString();
                        continue;
                    case 24:
                        this.timeNanos = input.readInt64();
                        continue;
                    case 34:
                        int i;
                        int arrayLength = WireFormatNano.getRepeatedFieldArrayLength(input, 34);
                        if (this.appInfo == null) {
                            i = 0;
                        } else {
                            i = this.appInfo.length;
                        }
                        AppInfoNormal[] newArray = new AppInfoNormal[(i + arrayLength)];
                        if (i != 0) {
                            System.arraycopy(this.appInfo, 0, newArray, 0, i);
                        }
                        while (i < newArray.length - 1) {
                            newArray[i] = new AppInfoNormal();
                            input.readMessage(newArray[i]);
                            input.readTag();
                            i++;
                        }
                        newArray[i] = new AppInfoNormal();
                        input.readMessage(newArray[i]);
                        this.appInfo = newArray;
                        continue;
                    case MotionEventCompat.AXIS_GENERIC_11 /*42*/:
                        this.data = input.readString();
                        continue;
                    default:
                        if (!super.storeUnknownField(input, tag)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public static EventLogNormal parseFrom(byte[] data) throws InvalidProtocolBufferNanoException {
            return (EventLogNormal) MessageNano.mergeFrom(new EventLogNormal(), data);
        }

        public static EventLogNormal parseFrom(CodedInputByteBufferNano input) throws IOException {
            return new EventLogNormal().mergeFrom(input);
        }
    }

    public static final class FilePresence extends ExtendableMessageNano<FilePresence> {
        private static volatile FilePresence[] _emptyArray;
        public boolean executable;
        public int fileGroup;
        public int fileOwner;
        public String filename;
        public long mtime;
        public int permissions;
        public boolean present;
        public String seLinuxSecurityContext;
        public byte[] sha256;
        public boolean symlink;
        public String symlinkTarget;

        public static FilePresence[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new FilePresence[0];
                    }
                }
            }
            return _emptyArray;
        }

        public FilePresence() {
            clear();
        }

        public FilePresence clear() {
            this.filename = "";
            this.present = false;
            this.sha256 = WireFormatNano.EMPTY_BYTES;
            this.mtime = 0;
            this.permissions = 0;
            this.fileOwner = 0;
            this.fileGroup = 0;
            this.seLinuxSecurityContext = "";
            this.executable = false;
            this.symlink = false;
            this.symlinkTarget = "";
            this.unknownFieldData = null;
            this.cachedSize = -1;
            return this;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof FilePresence)) {
                return false;
            }
            FilePresence other = (FilePresence) o;
            if (this.filename == null) {
                if (other.filename != null) {
                    return false;
                }
            } else if (!this.filename.equals(other.filename)) {
                return false;
            }
            if (this.present != other.present || !Arrays.equals(this.sha256, other.sha256) || this.mtime != other.mtime || this.permissions != other.permissions || this.fileOwner != other.fileOwner || this.fileGroup != other.fileGroup) {
                return false;
            }
            if (this.seLinuxSecurityContext == null) {
                if (other.seLinuxSecurityContext != null) {
                    return false;
                }
            } else if (!this.seLinuxSecurityContext.equals(other.seLinuxSecurityContext)) {
                return false;
            }
            if (this.executable != other.executable || this.symlink != other.symlink) {
                return false;
            }
            if (this.symlinkTarget == null) {
                if (other.symlinkTarget != null) {
                    return false;
                }
            } else if (!this.symlinkTarget.equals(other.symlinkTarget)) {
                return false;
            }
            if (this.unknownFieldData != null && !this.unknownFieldData.isEmpty()) {
                return this.unknownFieldData.equals(other.unknownFieldData);
            }
            if (other.unknownFieldData == null || other.unknownFieldData.isEmpty()) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int i;
            int i2 = 1231;
            int i3 = 0;
            int hashCode = (getClass().getName().hashCode() + 527) * 31;
            if (this.filename == null) {
                i = 0;
            } else {
                i = this.filename.hashCode();
            }
            hashCode = (hashCode + i) * 31;
            if (this.present) {
                i = 1231;
            } else {
                i = 1237;
            }
            hashCode = (((((((((((hashCode + i) * 31) + Arrays.hashCode(this.sha256)) * 31) + ((int) (this.mtime ^ (this.mtime >>> 32)))) * 31) + this.permissions) * 31) + this.fileOwner) * 31) + this.fileGroup) * 31;
            if (this.seLinuxSecurityContext == null) {
                i = 0;
            } else {
                i = this.seLinuxSecurityContext.hashCode();
            }
            hashCode = (hashCode + i) * 31;
            if (this.executable) {
                i = 1231;
            } else {
                i = 1237;
            }
            i = (hashCode + i) * 31;
            if (!this.symlink) {
                i2 = 1237;
            }
            i2 = (i + i2) * 31;
            if (this.symlinkTarget == null) {
                i = 0;
            } else {
                i = this.symlinkTarget.hashCode();
            }
            i = (i2 + i) * 31;
            if (!(this.unknownFieldData == null || this.unknownFieldData.isEmpty())) {
                i3 = this.unknownFieldData.hashCode();
            }
            return i + i3;
        }

        public void writeTo(CodedOutputByteBufferNano output) throws IOException {
            if (!(this.filename == null || this.filename.equals(""))) {
                output.writeString(1, this.filename);
            }
            if (this.present) {
                output.writeBool(2, this.present);
            }
            if (!Arrays.equals(this.sha256, WireFormatNano.EMPTY_BYTES)) {
                output.writeBytes(3, this.sha256);
            }
            if (this.mtime != 0) {
                output.writeInt64(4, this.mtime);
            }
            if (this.permissions != 0) {
                output.writeInt32(5, this.permissions);
            }
            if (this.fileOwner != 0) {
                output.writeInt32(6, this.fileOwner);
            }
            if (this.fileGroup != 0) {
                output.writeInt32(7, this.fileGroup);
            }
            if (!(this.seLinuxSecurityContext == null || this.seLinuxSecurityContext.equals(""))) {
                output.writeString(8, this.seLinuxSecurityContext);
            }
            if (this.executable) {
                output.writeBool(9, this.executable);
            }
            if (this.symlink) {
                output.writeBool(10, this.symlink);
            }
            if (!(this.symlinkTarget == null || this.symlinkTarget.equals(""))) {
                output.writeString(11, this.symlinkTarget);
            }
            super.writeTo(output);
        }

        protected int computeSerializedSize() {
            int size = super.computeSerializedSize();
            if (!(this.filename == null || this.filename.equals(""))) {
                size += CodedOutputByteBufferNano.computeStringSize(1, this.filename);
            }
            if (this.present) {
                size += CodedOutputByteBufferNano.computeBoolSize(2, this.present);
            }
            if (!Arrays.equals(this.sha256, WireFormatNano.EMPTY_BYTES)) {
                size += CodedOutputByteBufferNano.computeBytesSize(3, this.sha256);
            }
            if (this.mtime != 0) {
                size += CodedOutputByteBufferNano.computeInt64Size(4, this.mtime);
            }
            if (this.permissions != 0) {
                size += CodedOutputByteBufferNano.computeInt32Size(5, this.permissions);
            }
            if (this.fileOwner != 0) {
                size += CodedOutputByteBufferNano.computeInt32Size(6, this.fileOwner);
            }
            if (this.fileGroup != 0) {
                size += CodedOutputByteBufferNano.computeInt32Size(7, this.fileGroup);
            }
            if (!(this.seLinuxSecurityContext == null || this.seLinuxSecurityContext.equals(""))) {
                size += CodedOutputByteBufferNano.computeStringSize(8, this.seLinuxSecurityContext);
            }
            if (this.executable) {
                size += CodedOutputByteBufferNano.computeBoolSize(9, this.executable);
            }
            if (this.symlink) {
                size += CodedOutputByteBufferNano.computeBoolSize(10, this.symlink);
            }
            if (this.symlinkTarget == null || this.symlinkTarget.equals("")) {
                return size;
            }
            return size + CodedOutputByteBufferNano.computeStringSize(11, this.symlinkTarget);
        }

        public FilePresence mergeFrom(CodedInputByteBufferNano input) throws IOException {
            while (true) {
                int tag = input.readTag();
                switch (tag) {
                    case 0:
                        break;
                    case 10:
                        this.filename = input.readString();
                        continue;
                    case 16:
                        this.present = input.readBool();
                        continue;
                    case LogSource.ANDROID_CAMERA /*26*/:
                        this.sha256 = input.readBytes();
                        continue;
                    case 32:
                        this.mtime = input.readInt64();
                        continue;
                    case 40:
                        this.permissions = input.readInt32();
                        continue;
                    case 48:
                        this.fileOwner = input.readInt32();
                        continue;
                    case 56:
                        this.fileGroup = input.readInt32();
                        continue;
                    case 66:
                        this.seLinuxSecurityContext = input.readString();
                        continue;
                    case 72:
                        this.executable = input.readBool();
                        continue;
                    case 80:
                        this.symlink = input.readBool();
                        continue;
                    case 90:
                        this.symlinkTarget = input.readString();
                        continue;
                    default:
                        if (!super.storeUnknownField(input, tag)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public static FilePresence parseFrom(byte[] data) throws InvalidProtocolBufferNanoException {
            return (FilePresence) MessageNano.mergeFrom(new FilePresence(), data);
        }

        public static FilePresence parseFrom(CodedInputByteBufferNano input) throws IOException {
            return new FilePresence().mergeFrom(input);
        }
    }

    public static final class GoogleWebpageInfo extends ExtendableMessageNano<GoogleWebpageInfo> {
        private static volatile GoogleWebpageInfo[] _emptyArray;
        public boolean fetched;
        public boolean lengthExceedsThreshold;
        public int lengthThreshold;

        public static GoogleWebpageInfo[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new GoogleWebpageInfo[0];
                    }
                }
            }
            return _emptyArray;
        }

        public GoogleWebpageInfo() {
            clear();
        }

        public GoogleWebpageInfo clear() {
            this.fetched = false;
            this.lengthExceedsThreshold = false;
            this.lengthThreshold = 0;
            this.unknownFieldData = null;
            this.cachedSize = -1;
            return this;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof GoogleWebpageInfo)) {
                return false;
            }
            GoogleWebpageInfo other = (GoogleWebpageInfo) o;
            if (this.fetched != other.fetched || this.lengthExceedsThreshold != other.lengthExceedsThreshold || this.lengthThreshold != other.lengthThreshold) {
                return false;
            }
            if (this.unknownFieldData != null && !this.unknownFieldData.isEmpty()) {
                return this.unknownFieldData.equals(other.unknownFieldData);
            }
            if (other.unknownFieldData == null || other.unknownFieldData.isEmpty()) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int i = 1231;
            int hashCode = (((getClass().getName().hashCode() + 527) * 31) + (this.fetched ? 1231 : 1237)) * 31;
            if (!this.lengthExceedsThreshold) {
                i = 1237;
            }
            i = (((hashCode + i) * 31) + this.lengthThreshold) * 31;
            if (this.unknownFieldData == null || this.unknownFieldData.isEmpty()) {
                hashCode = 0;
            } else {
                hashCode = this.unknownFieldData.hashCode();
            }
            return i + hashCode;
        }

        public void writeTo(CodedOutputByteBufferNano output) throws IOException {
            if (this.fetched) {
                output.writeBool(1, this.fetched);
            }
            if (this.lengthExceedsThreshold) {
                output.writeBool(2, this.lengthExceedsThreshold);
            }
            if (this.lengthThreshold != 0) {
                output.writeInt32(3, this.lengthThreshold);
            }
            super.writeTo(output);
        }

        protected int computeSerializedSize() {
            int size = super.computeSerializedSize();
            if (this.fetched) {
                size += CodedOutputByteBufferNano.computeBoolSize(1, this.fetched);
            }
            if (this.lengthExceedsThreshold) {
                size += CodedOutputByteBufferNano.computeBoolSize(2, this.lengthExceedsThreshold);
            }
            if (this.lengthThreshold != 0) {
                return size + CodedOutputByteBufferNano.computeInt32Size(3, this.lengthThreshold);
            }
            return size;
        }

        public GoogleWebpageInfo mergeFrom(CodedInputByteBufferNano input) throws IOException {
            while (true) {
                int tag = input.readTag();
                switch (tag) {
                    case 0:
                        break;
                    case 8:
                        this.fetched = input.readBool();
                        continue;
                    case 16:
                        this.lengthExceedsThreshold = input.readBool();
                        continue;
                    case 24:
                        this.lengthThreshold = input.readInt32();
                        continue;
                    default:
                        if (!super.storeUnknownField(input, tag)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public static GoogleWebpageInfo parseFrom(byte[] data) throws InvalidProtocolBufferNanoException {
            return (GoogleWebpageInfo) MessageNano.mergeFrom(new GoogleWebpageInfo(), data);
        }

        public static GoogleWebpageInfo parseFrom(CodedInputByteBufferNano input) throws IOException {
            return new GoogleWebpageInfo().mergeFrom(input);
        }
    }

    public static final class LogcatEntryNormal extends ExtendableMessageNano<LogcatEntryNormal> {
        private static volatile LogcatEntryNormal[] _emptyArray;
        public String key;
        public LogcatValueNormal[] value;

        public static LogcatEntryNormal[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new LogcatEntryNormal[0];
                    }
                }
            }
            return _emptyArray;
        }

        public LogcatEntryNormal() {
            clear();
        }

        public LogcatEntryNormal clear() {
            this.key = "";
            this.value = LogcatValueNormal.emptyArray();
            this.unknownFieldData = null;
            this.cachedSize = -1;
            return this;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof LogcatEntryNormal)) {
                return false;
            }
            LogcatEntryNormal other = (LogcatEntryNormal) o;
            if (this.key == null) {
                if (other.key != null) {
                    return false;
                }
            } else if (!this.key.equals(other.key)) {
                return false;
            }
            if (!InternalNano.equals(this.value, other.value)) {
                return false;
            }
            if (this.unknownFieldData != null && !this.unknownFieldData.isEmpty()) {
                return this.unknownFieldData.equals(other.unknownFieldData);
            }
            if (other.unknownFieldData == null || other.unknownFieldData.isEmpty()) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int i;
            int i2 = 0;
            int hashCode = (getClass().getName().hashCode() + 527) * 31;
            if (this.key == null) {
                i = 0;
            } else {
                i = this.key.hashCode();
            }
            i = (((hashCode + i) * 31) + InternalNano.hashCode(this.value)) * 31;
            if (!(this.unknownFieldData == null || this.unknownFieldData.isEmpty())) {
                i2 = this.unknownFieldData.hashCode();
            }
            return i + i2;
        }

        public void writeTo(CodedOutputByteBufferNano output) throws IOException {
            if (!(this.key == null || this.key.equals(""))) {
                output.writeString(1, this.key);
            }
            if (this.value != null && this.value.length > 0) {
                for (LogcatValueNormal element : this.value) {
                    if (element != null) {
                        output.writeMessage(2, element);
                    }
                }
            }
            super.writeTo(output);
        }

        protected int computeSerializedSize() {
            int size = super.computeSerializedSize();
            if (!(this.key == null || this.key.equals(""))) {
                size += CodedOutputByteBufferNano.computeStringSize(1, this.key);
            }
            if (this.value != null && this.value.length > 0) {
                for (LogcatValueNormal element : this.value) {
                    if (element != null) {
                        size += CodedOutputByteBufferNano.computeMessageSize(2, element);
                    }
                }
            }
            return size;
        }

        public LogcatEntryNormal mergeFrom(CodedInputByteBufferNano input) throws IOException {
            while (true) {
                int tag = input.readTag();
                switch (tag) {
                    case 0:
                        break;
                    case 10:
                        this.key = input.readString();
                        continue;
                    case 18:
                        int i;
                        int arrayLength = WireFormatNano.getRepeatedFieldArrayLength(input, 18);
                        if (this.value == null) {
                            i = 0;
                        } else {
                            i = this.value.length;
                        }
                        LogcatValueNormal[] newArray = new LogcatValueNormal[(i + arrayLength)];
                        if (i != 0) {
                            System.arraycopy(this.value, 0, newArray, 0, i);
                        }
                        while (i < newArray.length - 1) {
                            newArray[i] = new LogcatValueNormal();
                            input.readMessage(newArray[i]);
                            input.readTag();
                            i++;
                        }
                        newArray[i] = new LogcatValueNormal();
                        input.readMessage(newArray[i]);
                        this.value = newArray;
                        continue;
                    default:
                        if (!super.storeUnknownField(input, tag)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public static LogcatEntryNormal parseFrom(byte[] data) throws InvalidProtocolBufferNanoException {
            return (LogcatEntryNormal) MessageNano.mergeFrom(new LogcatEntryNormal(), data);
        }

        public static LogcatEntryNormal parseFrom(CodedInputByteBufferNano input) throws IOException {
            return new LogcatEntryNormal().mergeFrom(input);
        }
    }

    public static final class LogcatResultsNormal extends ExtendableMessageNano<LogcatResultsNormal> {
        private static volatile LogcatResultsNormal[] _emptyArray;
        public int numLogcatLines;
        public LogcatEntryNormal[] results;

        public static LogcatResultsNormal[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new LogcatResultsNormal[0];
                    }
                }
            }
            return _emptyArray;
        }

        public LogcatResultsNormal() {
            clear();
        }

        public LogcatResultsNormal clear() {
            this.numLogcatLines = 0;
            this.results = LogcatEntryNormal.emptyArray();
            this.unknownFieldData = null;
            this.cachedSize = -1;
            return this;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof LogcatResultsNormal)) {
                return false;
            }
            LogcatResultsNormal other = (LogcatResultsNormal) o;
            if (this.numLogcatLines != other.numLogcatLines || !InternalNano.equals(this.results, other.results)) {
                return false;
            }
            if (this.unknownFieldData != null && !this.unknownFieldData.isEmpty()) {
                return this.unknownFieldData.equals(other.unknownFieldData);
            }
            if (other.unknownFieldData == null || other.unknownFieldData.isEmpty()) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int i;
            int hashCode = (((((getClass().getName().hashCode() + 527) * 31) + this.numLogcatLines) * 31) + InternalNano.hashCode(this.results)) * 31;
            if (this.unknownFieldData == null || this.unknownFieldData.isEmpty()) {
                i = 0;
            } else {
                i = this.unknownFieldData.hashCode();
            }
            return hashCode + i;
        }

        public void writeTo(CodedOutputByteBufferNano output) throws IOException {
            if (this.numLogcatLines != 0) {
                output.writeInt32(1, this.numLogcatLines);
            }
            if (this.results != null && this.results.length > 0) {
                for (LogcatEntryNormal element : this.results) {
                    if (element != null) {
                        output.writeMessage(2, element);
                    }
                }
            }
            super.writeTo(output);
        }

        protected int computeSerializedSize() {
            int size = super.computeSerializedSize();
            if (this.numLogcatLines != 0) {
                size += CodedOutputByteBufferNano.computeInt32Size(1, this.numLogcatLines);
            }
            if (this.results != null && this.results.length > 0) {
                for (LogcatEntryNormal element : this.results) {
                    if (element != null) {
                        size += CodedOutputByteBufferNano.computeMessageSize(2, element);
                    }
                }
            }
            return size;
        }

        public LogcatResultsNormal mergeFrom(CodedInputByteBufferNano input) throws IOException {
            while (true) {
                int tag = input.readTag();
                switch (tag) {
                    case 0:
                        break;
                    case 8:
                        this.numLogcatLines = input.readInt32();
                        continue;
                    case 18:
                        int i;
                        int arrayLength = WireFormatNano.getRepeatedFieldArrayLength(input, 18);
                        if (this.results == null) {
                            i = 0;
                        } else {
                            i = this.results.length;
                        }
                        LogcatEntryNormal[] newArray = new LogcatEntryNormal[(i + arrayLength)];
                        if (i != 0) {
                            System.arraycopy(this.results, 0, newArray, 0, i);
                        }
                        while (i < newArray.length - 1) {
                            newArray[i] = new LogcatEntryNormal();
                            input.readMessage(newArray[i]);
                            input.readTag();
                            i++;
                        }
                        newArray[i] = new LogcatEntryNormal();
                        input.readMessage(newArray[i]);
                        this.results = newArray;
                        continue;
                    default:
                        if (!super.storeUnknownField(input, tag)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public static LogcatResultsNormal parseFrom(byte[] data) throws InvalidProtocolBufferNanoException {
            return (LogcatResultsNormal) MessageNano.mergeFrom(new LogcatResultsNormal(), data);
        }

        public static LogcatResultsNormal parseFrom(CodedInputByteBufferNano input) throws IOException {
            return new LogcatResultsNormal().mergeFrom(input);
        }
    }

    public static final class LogcatValueNormal extends ExtendableMessageNano<LogcatValueNormal> {
        private static volatile LogcatValueNormal[] _emptyArray;
        public AppInfoNormal[] appInfo;
        public String line;

        public static LogcatValueNormal[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new LogcatValueNormal[0];
                    }
                }
            }
            return _emptyArray;
        }

        public LogcatValueNormal() {
            clear();
        }

        public LogcatValueNormal clear() {
            this.appInfo = AppInfoNormal.emptyArray();
            this.line = "";
            this.unknownFieldData = null;
            this.cachedSize = -1;
            return this;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof LogcatValueNormal)) {
                return false;
            }
            LogcatValueNormal other = (LogcatValueNormal) o;
            if (!InternalNano.equals(this.appInfo, other.appInfo)) {
                return false;
            }
            if (this.line == null) {
                if (other.line != null) {
                    return false;
                }
            } else if (!this.line.equals(other.line)) {
                return false;
            }
            if (this.unknownFieldData != null && !this.unknownFieldData.isEmpty()) {
                return this.unknownFieldData.equals(other.unknownFieldData);
            }
            if (other.unknownFieldData == null || other.unknownFieldData.isEmpty()) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int i;
            int i2 = 0;
            int hashCode = (((getClass().getName().hashCode() + 527) * 31) + InternalNano.hashCode(this.appInfo)) * 31;
            if (this.line == null) {
                i = 0;
            } else {
                i = this.line.hashCode();
            }
            i = (hashCode + i) * 31;
            if (!(this.unknownFieldData == null || this.unknownFieldData.isEmpty())) {
                i2 = this.unknownFieldData.hashCode();
            }
            return i + i2;
        }

        public void writeTo(CodedOutputByteBufferNano output) throws IOException {
            if (this.appInfo != null && this.appInfo.length > 0) {
                for (AppInfoNormal element : this.appInfo) {
                    if (element != null) {
                        output.writeMessage(1, element);
                    }
                }
            }
            if (!(this.line == null || this.line.equals(""))) {
                output.writeString(2, this.line);
            }
            super.writeTo(output);
        }

        protected int computeSerializedSize() {
            int size = super.computeSerializedSize();
            if (this.appInfo != null && this.appInfo.length > 0) {
                for (AppInfoNormal element : this.appInfo) {
                    if (element != null) {
                        size += CodedOutputByteBufferNano.computeMessageSize(1, element);
                    }
                }
            }
            if (this.line == null || this.line.equals("")) {
                return size;
            }
            return size + CodedOutputByteBufferNano.computeStringSize(2, this.line);
        }

        public LogcatValueNormal mergeFrom(CodedInputByteBufferNano input) throws IOException {
            while (true) {
                int tag = input.readTag();
                switch (tag) {
                    case 0:
                        break;
                    case 10:
                        int i;
                        int arrayLength = WireFormatNano.getRepeatedFieldArrayLength(input, 10);
                        if (this.appInfo == null) {
                            i = 0;
                        } else {
                            i = this.appInfo.length;
                        }
                        AppInfoNormal[] newArray = new AppInfoNormal[(i + arrayLength)];
                        if (i != 0) {
                            System.arraycopy(this.appInfo, 0, newArray, 0, i);
                        }
                        while (i < newArray.length - 1) {
                            newArray[i] = new AppInfoNormal();
                            input.readMessage(newArray[i]);
                            input.readTag();
                            i++;
                        }
                        newArray[i] = new AppInfoNormal();
                        input.readMessage(newArray[i]);
                        this.appInfo = newArray;
                        continue;
                    case 18:
                        this.line = input.readString();
                        continue;
                    default:
                        if (!super.storeUnknownField(input, tag)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public static LogcatValueNormal parseFrom(byte[] data) throws InvalidProtocolBufferNanoException {
            return (LogcatValueNormal) MessageNano.mergeFrom(new LogcatValueNormal(), data);
        }

        public static LogcatValueNormal parseFrom(CodedInputByteBufferNano input) throws IOException {
            return new LogcatValueNormal().mergeFrom(input);
        }
    }

    public static final class OkHttpSslv3FallbackInfo extends ExtendableMessageNano<OkHttpSslv3FallbackInfo> {
        private static volatile OkHttpSslv3FallbackInfo[] _emptyArray;
        public boolean initialConnAttempted;
        public boolean initialConnSucceeded;
        public boolean retryAttempted;
        public boolean retrySucceeded;
        public boolean retryUsedModernTls;

        public static OkHttpSslv3FallbackInfo[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new OkHttpSslv3FallbackInfo[0];
                    }
                }
            }
            return _emptyArray;
        }

        public OkHttpSslv3FallbackInfo() {
            clear();
        }

        public OkHttpSslv3FallbackInfo clear() {
            this.initialConnAttempted = false;
            this.initialConnSucceeded = false;
            this.retryAttempted = false;
            this.retrySucceeded = false;
            this.retryUsedModernTls = false;
            this.unknownFieldData = null;
            this.cachedSize = -1;
            return this;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof OkHttpSslv3FallbackInfo)) {
                return false;
            }
            OkHttpSslv3FallbackInfo other = (OkHttpSslv3FallbackInfo) o;
            if (this.initialConnAttempted != other.initialConnAttempted || this.initialConnSucceeded != other.initialConnSucceeded || this.retryAttempted != other.retryAttempted || this.retrySucceeded != other.retrySucceeded || this.retryUsedModernTls != other.retryUsedModernTls) {
                return false;
            }
            if (this.unknownFieldData != null && !this.unknownFieldData.isEmpty()) {
                return this.unknownFieldData.equals(other.unknownFieldData);
            }
            if (other.unknownFieldData == null || other.unknownFieldData.isEmpty()) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int i;
            int i2 = 1231;
            int hashCode = (((getClass().getName().hashCode() + 527) * 31) + (this.initialConnAttempted ? 1231 : 1237)) * 31;
            if (this.initialConnSucceeded) {
                i = 1231;
            } else {
                i = 1237;
            }
            hashCode = (hashCode + i) * 31;
            if (this.retryAttempted) {
                i = 1231;
            } else {
                i = 1237;
            }
            hashCode = (hashCode + i) * 31;
            if (this.retrySucceeded) {
                i = 1231;
            } else {
                i = 1237;
            }
            i = (hashCode + i) * 31;
            if (!this.retryUsedModernTls) {
                i2 = 1237;
            }
            i2 = (i + i2) * 31;
            if (this.unknownFieldData == null || this.unknownFieldData.isEmpty()) {
                i = 0;
            } else {
                i = this.unknownFieldData.hashCode();
            }
            return i2 + i;
        }

        public void writeTo(CodedOutputByteBufferNano output) throws IOException {
            if (this.initialConnAttempted) {
                output.writeBool(1, this.initialConnAttempted);
            }
            if (this.initialConnSucceeded) {
                output.writeBool(2, this.initialConnSucceeded);
            }
            if (this.retryAttempted) {
                output.writeBool(3, this.retryAttempted);
            }
            if (this.retrySucceeded) {
                output.writeBool(4, this.retrySucceeded);
            }
            if (this.retryUsedModernTls) {
                output.writeBool(5, this.retryUsedModernTls);
            }
            super.writeTo(output);
        }

        protected int computeSerializedSize() {
            int size = super.computeSerializedSize();
            if (this.initialConnAttempted) {
                size += CodedOutputByteBufferNano.computeBoolSize(1, this.initialConnAttempted);
            }
            if (this.initialConnSucceeded) {
                size += CodedOutputByteBufferNano.computeBoolSize(2, this.initialConnSucceeded);
            }
            if (this.retryAttempted) {
                size += CodedOutputByteBufferNano.computeBoolSize(3, this.retryAttempted);
            }
            if (this.retrySucceeded) {
                size += CodedOutputByteBufferNano.computeBoolSize(4, this.retrySucceeded);
            }
            if (this.retryUsedModernTls) {
                return size + CodedOutputByteBufferNano.computeBoolSize(5, this.retryUsedModernTls);
            }
            return size;
        }

        public OkHttpSslv3FallbackInfo mergeFrom(CodedInputByteBufferNano input) throws IOException {
            while (true) {
                int tag = input.readTag();
                switch (tag) {
                    case 0:
                        break;
                    case 8:
                        this.initialConnAttempted = input.readBool();
                        continue;
                    case 16:
                        this.initialConnSucceeded = input.readBool();
                        continue;
                    case 24:
                        this.retryAttempted = input.readBool();
                        continue;
                    case 32:
                        this.retrySucceeded = input.readBool();
                        continue;
                    case 40:
                        this.retryUsedModernTls = input.readBool();
                        continue;
                    default:
                        if (!super.storeUnknownField(input, tag)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public static OkHttpSslv3FallbackInfo parseFrom(byte[] data) throws InvalidProtocolBufferNanoException {
            return (OkHttpSslv3FallbackInfo) MessageNano.mergeFrom(new OkHttpSslv3FallbackInfo(), data);
        }

        public static OkHttpSslv3FallbackInfo parseFrom(CodedInputByteBufferNano input) throws IOException {
            return new OkHttpSslv3FallbackInfo().mergeFrom(input);
        }
    }

    public static final class PackageInfo extends ExtendableMessageNano<PackageInfo> {
        private static volatile PackageInfo[] _emptyArray;
        public boolean noDefault;
        public String packageName;
        public int versionCode;
        public String versionName;

        public static PackageInfo[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new PackageInfo[0];
                    }
                }
            }
            return _emptyArray;
        }

        public PackageInfo() {
            clear();
        }

        public PackageInfo clear() {
            this.packageName = "";
            this.versionCode = 0;
            this.versionName = "";
            this.noDefault = false;
            this.unknownFieldData = null;
            this.cachedSize = -1;
            return this;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof PackageInfo)) {
                return false;
            }
            PackageInfo other = (PackageInfo) o;
            if (this.packageName == null) {
                if (other.packageName != null) {
                    return false;
                }
            } else if (!this.packageName.equals(other.packageName)) {
                return false;
            }
            if (this.versionCode != other.versionCode) {
                return false;
            }
            if (this.versionName == null) {
                if (other.versionName != null) {
                    return false;
                }
            } else if (!this.versionName.equals(other.versionName)) {
                return false;
            }
            if (this.noDefault != other.noDefault) {
                return false;
            }
            if (this.unknownFieldData != null && !this.unknownFieldData.isEmpty()) {
                return this.unknownFieldData.equals(other.unknownFieldData);
            }
            if (other.unknownFieldData == null || other.unknownFieldData.isEmpty()) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int i;
            int i2 = 0;
            int hashCode = (getClass().getName().hashCode() + 527) * 31;
            if (this.packageName == null) {
                i = 0;
            } else {
                i = this.packageName.hashCode();
            }
            hashCode = (((hashCode + i) * 31) + this.versionCode) * 31;
            if (this.versionName == null) {
                i = 0;
            } else {
                i = this.versionName.hashCode();
            }
            i = (((hashCode + i) * 31) + (this.noDefault ? 1231 : 1237)) * 31;
            if (!(this.unknownFieldData == null || this.unknownFieldData.isEmpty())) {
                i2 = this.unknownFieldData.hashCode();
            }
            return i + i2;
        }

        public void writeTo(CodedOutputByteBufferNano output) throws IOException {
            if (!(this.packageName == null || this.packageName.equals(""))) {
                output.writeString(1, this.packageName);
            }
            if (this.versionCode != 0) {
                output.writeInt32(2, this.versionCode);
            }
            if (!(this.versionName == null || this.versionName.equals(""))) {
                output.writeString(3, this.versionName);
            }
            if (this.noDefault) {
                output.writeBool(4, this.noDefault);
            }
            super.writeTo(output);
        }

        protected int computeSerializedSize() {
            int size = super.computeSerializedSize();
            if (!(this.packageName == null || this.packageName.equals(""))) {
                size += CodedOutputByteBufferNano.computeStringSize(1, this.packageName);
            }
            if (this.versionCode != 0) {
                size += CodedOutputByteBufferNano.computeInt32Size(2, this.versionCode);
            }
            if (!(this.versionName == null || this.versionName.equals(""))) {
                size += CodedOutputByteBufferNano.computeStringSize(3, this.versionName);
            }
            if (this.noDefault) {
                return size + CodedOutputByteBufferNano.computeBoolSize(4, this.noDefault);
            }
            return size;
        }

        public PackageInfo mergeFrom(CodedInputByteBufferNano input) throws IOException {
            while (true) {
                int tag = input.readTag();
                switch (tag) {
                    case 0:
                        break;
                    case 10:
                        this.packageName = input.readString();
                        continue;
                    case 16:
                        this.versionCode = input.readInt32();
                        continue;
                    case LogSource.ANDROID_CAMERA /*26*/:
                        this.versionName = input.readString();
                        continue;
                    case 32:
                        this.noDefault = input.readBool();
                        continue;
                    default:
                        if (!super.storeUnknownField(input, tag)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public static PackageInfo parseFrom(byte[] data) throws InvalidProtocolBufferNanoException {
            return (PackageInfo) MessageNano.mergeFrom(new PackageInfo(), data);
        }

        public static PackageInfo parseFrom(CodedInputByteBufferNano input) throws IOException {
            return new PackageInfo().mergeFrom(input);
        }
    }

    public static final class ProxyInfo extends ExtendableMessageNano<ProxyInfo> {
        private static volatile ProxyInfo[] _emptyArray;
        public String address;
        public boolean localIp;
        public boolean present;

        public static ProxyInfo[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new ProxyInfo[0];
                    }
                }
            }
            return _emptyArray;
        }

        public ProxyInfo() {
            clear();
        }

        public ProxyInfo clear() {
            this.present = false;
            this.localIp = false;
            this.address = "";
            this.unknownFieldData = null;
            this.cachedSize = -1;
            return this;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof ProxyInfo)) {
                return false;
            }
            ProxyInfo other = (ProxyInfo) o;
            if (this.present != other.present || this.localIp != other.localIp) {
                return false;
            }
            if (this.address == null) {
                if (other.address != null) {
                    return false;
                }
            } else if (!this.address.equals(other.address)) {
                return false;
            }
            if (this.unknownFieldData != null && !this.unknownFieldData.isEmpty()) {
                return this.unknownFieldData.equals(other.unknownFieldData);
            }
            if (other.unknownFieldData == null || other.unknownFieldData.isEmpty()) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int i = 1231;
            int i2 = 0;
            int hashCode = (((getClass().getName().hashCode() + 527) * 31) + (this.present ? 1231 : 1237)) * 31;
            if (!this.localIp) {
                i = 1237;
            }
            i = (hashCode + i) * 31;
            if (this.address == null) {
                hashCode = 0;
            } else {
                hashCode = this.address.hashCode();
            }
            hashCode = (i + hashCode) * 31;
            if (!(this.unknownFieldData == null || this.unknownFieldData.isEmpty())) {
                i2 = this.unknownFieldData.hashCode();
            }
            return hashCode + i2;
        }

        public void writeTo(CodedOutputByteBufferNano output) throws IOException {
            if (this.present) {
                output.writeBool(1, this.present);
            }
            if (this.localIp) {
                output.writeBool(2, this.localIp);
            }
            if (!(this.address == null || this.address.equals(""))) {
                output.writeString(3, this.address);
            }
            super.writeTo(output);
        }

        protected int computeSerializedSize() {
            int size = super.computeSerializedSize();
            if (this.present) {
                size += CodedOutputByteBufferNano.computeBoolSize(1, this.present);
            }
            if (this.localIp) {
                size += CodedOutputByteBufferNano.computeBoolSize(2, this.localIp);
            }
            if (this.address == null || this.address.equals("")) {
                return size;
            }
            return size + CodedOutputByteBufferNano.computeStringSize(3, this.address);
        }

        public ProxyInfo mergeFrom(CodedInputByteBufferNano input) throws IOException {
            while (true) {
                int tag = input.readTag();
                switch (tag) {
                    case 0:
                        break;
                    case 8:
                        this.present = input.readBool();
                        continue;
                    case 16:
                        this.localIp = input.readBool();
                        continue;
                    case LogSource.ANDROID_CAMERA /*26*/:
                        this.address = input.readString();
                        continue;
                    default:
                        if (!super.storeUnknownField(input, tag)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public static ProxyInfo parseFrom(byte[] data) throws InvalidProtocolBufferNanoException {
            return (ProxyInfo) MessageNano.mergeFrom(new ProxyInfo(), data);
        }

        public static ProxyInfo parseFrom(CodedInputByteBufferNano input) throws IOException {
            return new ProxyInfo().mergeFrom(input);
        }
    }

    public static final class RunSettingsNormal extends ExtendableMessageNano<RunSettingsNormal> {
        private static volatile RunSettingsNormal[] _emptyArray;
        public long currentTimeMs;
        public long durationSinceLastRunMs;
        public long executionTimeMs;
        public long wakeIntervalMs;

        public static RunSettingsNormal[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new RunSettingsNormal[0];
                    }
                }
            }
            return _emptyArray;
        }

        public RunSettingsNormal() {
            clear();
        }

        public RunSettingsNormal clear() {
            this.wakeIntervalMs = 0;
            this.durationSinceLastRunMs = 0;
            this.executionTimeMs = 0;
            this.currentTimeMs = 0;
            this.unknownFieldData = null;
            this.cachedSize = -1;
            return this;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof RunSettingsNormal)) {
                return false;
            }
            RunSettingsNormal other = (RunSettingsNormal) o;
            if (this.wakeIntervalMs != other.wakeIntervalMs || this.durationSinceLastRunMs != other.durationSinceLastRunMs || this.executionTimeMs != other.executionTimeMs || this.currentTimeMs != other.currentTimeMs) {
                return false;
            }
            if (this.unknownFieldData != null && !this.unknownFieldData.isEmpty()) {
                return this.unknownFieldData.equals(other.unknownFieldData);
            }
            if (other.unknownFieldData == null || other.unknownFieldData.isEmpty()) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int i;
            int hashCode = (((((((((getClass().getName().hashCode() + 527) * 31) + ((int) (this.wakeIntervalMs ^ (this.wakeIntervalMs >>> 32)))) * 31) + ((int) (this.durationSinceLastRunMs ^ (this.durationSinceLastRunMs >>> 32)))) * 31) + ((int) (this.executionTimeMs ^ (this.executionTimeMs >>> 32)))) * 31) + ((int) (this.currentTimeMs ^ (this.currentTimeMs >>> 32)))) * 31;
            if (this.unknownFieldData == null || this.unknownFieldData.isEmpty()) {
                i = 0;
            } else {
                i = this.unknownFieldData.hashCode();
            }
            return hashCode + i;
        }

        public void writeTo(CodedOutputByteBufferNano output) throws IOException {
            if (this.wakeIntervalMs != 0) {
                output.writeInt64(1, this.wakeIntervalMs);
            }
            if (this.durationSinceLastRunMs != 0) {
                output.writeInt64(2, this.durationSinceLastRunMs);
            }
            if (this.executionTimeMs != 0) {
                output.writeInt64(3, this.executionTimeMs);
            }
            if (this.currentTimeMs != 0) {
                output.writeInt64(4, this.currentTimeMs);
            }
            super.writeTo(output);
        }

        protected int computeSerializedSize() {
            int size = super.computeSerializedSize();
            if (this.wakeIntervalMs != 0) {
                size += CodedOutputByteBufferNano.computeInt64Size(1, this.wakeIntervalMs);
            }
            if (this.durationSinceLastRunMs != 0) {
                size += CodedOutputByteBufferNano.computeInt64Size(2, this.durationSinceLastRunMs);
            }
            if (this.executionTimeMs != 0) {
                size += CodedOutputByteBufferNano.computeInt64Size(3, this.executionTimeMs);
            }
            if (this.currentTimeMs != 0) {
                return size + CodedOutputByteBufferNano.computeInt64Size(4, this.currentTimeMs);
            }
            return size;
        }

        public RunSettingsNormal mergeFrom(CodedInputByteBufferNano input) throws IOException {
            while (true) {
                int tag = input.readTag();
                switch (tag) {
                    case 0:
                        break;
                    case 8:
                        this.wakeIntervalMs = input.readInt64();
                        continue;
                    case 16:
                        this.durationSinceLastRunMs = input.readInt64();
                        continue;
                    case 24:
                        this.executionTimeMs = input.readInt64();
                        continue;
                    case 32:
                        this.currentTimeMs = input.readInt64();
                        continue;
                    default:
                        if (!super.storeUnknownField(input, tag)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public static RunSettingsNormal parseFrom(byte[] data) throws InvalidProtocolBufferNanoException {
            return (RunSettingsNormal) MessageNano.mergeFrom(new RunSettingsNormal(), data);
        }

        public static RunSettingsNormal parseFrom(CodedInputByteBufferNano input) throws IOException {
            return new RunSettingsNormal().mergeFrom(input);
        }
    }

    public static final class SdCardInfo extends ExtendableMessageNano<SdCardInfo> {
        private static volatile SdCardInfo[] _emptyArray;
        public String jpegFileName;
        public boolean jpegMissing;
        public long jpegModificationTime;
        public boolean jpegNewlyTampered;
        public boolean jpegTampered;
        public int jpegTamperedBytes;
        public long jpegWrongLength;

        public static SdCardInfo[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new SdCardInfo[0];
                    }
                }
            }
            return _emptyArray;
        }

        public SdCardInfo() {
            clear();
        }

        public SdCardInfo clear() {
            this.jpegMissing = false;
            this.jpegTampered = false;
            this.jpegWrongLength = 0;
            this.jpegTamperedBytes = 0;
            this.jpegNewlyTampered = false;
            this.jpegFileName = "";
            this.jpegModificationTime = 0;
            this.unknownFieldData = null;
            this.cachedSize = -1;
            return this;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof SdCardInfo)) {
                return false;
            }
            SdCardInfo other = (SdCardInfo) o;
            if (this.jpegMissing != other.jpegMissing || this.jpegTampered != other.jpegTampered || this.jpegWrongLength != other.jpegWrongLength || this.jpegTamperedBytes != other.jpegTamperedBytes || this.jpegNewlyTampered != other.jpegNewlyTampered) {
                return false;
            }
            if (this.jpegFileName == null) {
                if (other.jpegFileName != null) {
                    return false;
                }
            } else if (!this.jpegFileName.equals(other.jpegFileName)) {
                return false;
            }
            if (this.jpegModificationTime != other.jpegModificationTime) {
                return false;
            }
            if (this.unknownFieldData != null && !this.unknownFieldData.isEmpty()) {
                return this.unknownFieldData.equals(other.unknownFieldData);
            }
            if (other.unknownFieldData == null || other.unknownFieldData.isEmpty()) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int i;
            int i2 = 0;
            int i3 = 1231;
            int hashCode = (((getClass().getName().hashCode() + 527) * 31) + (this.jpegMissing ? 1231 : 1237)) * 31;
            if (this.jpegTampered) {
                i = 1231;
            } else {
                i = 1237;
            }
            i = (((((hashCode + i) * 31) + ((int) (this.jpegWrongLength ^ (this.jpegWrongLength >>> 32)))) * 31) + this.jpegTamperedBytes) * 31;
            if (!this.jpegNewlyTampered) {
                i3 = 1237;
            }
            i3 = (i + i3) * 31;
            if (this.jpegFileName == null) {
                i = 0;
            } else {
                i = this.jpegFileName.hashCode();
            }
            i = (((i3 + i) * 31) + ((int) (this.jpegModificationTime ^ (this.jpegModificationTime >>> 32)))) * 31;
            if (!(this.unknownFieldData == null || this.unknownFieldData.isEmpty())) {
                i2 = this.unknownFieldData.hashCode();
            }
            return i + i2;
        }

        public void writeTo(CodedOutputByteBufferNano output) throws IOException {
            if (this.jpegMissing) {
                output.writeBool(1, this.jpegMissing);
            }
            if (this.jpegTampered) {
                output.writeBool(2, this.jpegTampered);
            }
            if (this.jpegWrongLength != 0) {
                output.writeInt64(3, this.jpegWrongLength);
            }
            if (this.jpegTamperedBytes != 0) {
                output.writeInt32(4, this.jpegTamperedBytes);
            }
            if (this.jpegNewlyTampered) {
                output.writeBool(5, this.jpegNewlyTampered);
            }
            if (!(this.jpegFileName == null || this.jpegFileName.equals(""))) {
                output.writeString(6, this.jpegFileName);
            }
            if (this.jpegModificationTime != 0) {
                output.writeInt64(7, this.jpegModificationTime);
            }
            super.writeTo(output);
        }

        protected int computeSerializedSize() {
            int size = super.computeSerializedSize();
            if (this.jpegMissing) {
                size += CodedOutputByteBufferNano.computeBoolSize(1, this.jpegMissing);
            }
            if (this.jpegTampered) {
                size += CodedOutputByteBufferNano.computeBoolSize(2, this.jpegTampered);
            }
            if (this.jpegWrongLength != 0) {
                size += CodedOutputByteBufferNano.computeInt64Size(3, this.jpegWrongLength);
            }
            if (this.jpegTamperedBytes != 0) {
                size += CodedOutputByteBufferNano.computeInt32Size(4, this.jpegTamperedBytes);
            }
            if (this.jpegNewlyTampered) {
                size += CodedOutputByteBufferNano.computeBoolSize(5, this.jpegNewlyTampered);
            }
            if (!(this.jpegFileName == null || this.jpegFileName.equals(""))) {
                size += CodedOutputByteBufferNano.computeStringSize(6, this.jpegFileName);
            }
            if (this.jpegModificationTime != 0) {
                return size + CodedOutputByteBufferNano.computeInt64Size(7, this.jpegModificationTime);
            }
            return size;
        }

        public SdCardInfo mergeFrom(CodedInputByteBufferNano input) throws IOException {
            while (true) {
                int tag = input.readTag();
                switch (tag) {
                    case 0:
                        break;
                    case 8:
                        this.jpegMissing = input.readBool();
                        continue;
                    case 16:
                        this.jpegTampered = input.readBool();
                        continue;
                    case 24:
                        this.jpegWrongLength = input.readInt64();
                        continue;
                    case 32:
                        this.jpegTamperedBytes = input.readInt32();
                        continue;
                    case 40:
                        this.jpegNewlyTampered = input.readBool();
                        continue;
                    case 50:
                        this.jpegFileName = input.readString();
                        continue;
                    case 56:
                        this.jpegModificationTime = input.readInt64();
                        continue;
                    default:
                        if (!super.storeUnknownField(input, tag)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public static SdCardInfo parseFrom(byte[] data) throws InvalidProtocolBufferNanoException {
            return (SdCardInfo) MessageNano.mergeFrom(new SdCardInfo(), data);
        }

        public static SdCardInfo parseFrom(CodedInputByteBufferNano input) throws IOException {
            return new SdCardInfo().mergeFrom(input);
        }
    }

    public static final class SeLinuxInfoNormal extends ExtendableMessageNano<SeLinuxInfoNormal> {
        private static volatile SeLinuxInfoNormal[] _emptyArray;
        public boolean enforcing;
        public boolean present;

        public static SeLinuxInfoNormal[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new SeLinuxInfoNormal[0];
                    }
                }
            }
            return _emptyArray;
        }

        public SeLinuxInfoNormal() {
            clear();
        }

        public SeLinuxInfoNormal clear() {
            this.present = false;
            this.enforcing = false;
            this.unknownFieldData = null;
            this.cachedSize = -1;
            return this;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof SeLinuxInfoNormal)) {
                return false;
            }
            SeLinuxInfoNormal other = (SeLinuxInfoNormal) o;
            if (this.present != other.present || this.enforcing != other.enforcing) {
                return false;
            }
            if (this.unknownFieldData != null && !this.unknownFieldData.isEmpty()) {
                return this.unknownFieldData.equals(other.unknownFieldData);
            }
            if (other.unknownFieldData == null || other.unknownFieldData.isEmpty()) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int i = 1231;
            int hashCode = (((getClass().getName().hashCode() + 527) * 31) + (this.present ? 1231 : 1237)) * 31;
            if (!this.enforcing) {
                i = 1237;
            }
            i = (hashCode + i) * 31;
            if (this.unknownFieldData == null || this.unknownFieldData.isEmpty()) {
                hashCode = 0;
            } else {
                hashCode = this.unknownFieldData.hashCode();
            }
            return i + hashCode;
        }

        public void writeTo(CodedOutputByteBufferNano output) throws IOException {
            if (this.present) {
                output.writeBool(1, this.present);
            }
            if (this.enforcing) {
                output.writeBool(2, this.enforcing);
            }
            super.writeTo(output);
        }

        protected int computeSerializedSize() {
            int size = super.computeSerializedSize();
            if (this.present) {
                size += CodedOutputByteBufferNano.computeBoolSize(1, this.present);
            }
            if (this.enforcing) {
                return size + CodedOutputByteBufferNano.computeBoolSize(2, this.enforcing);
            }
            return size;
        }

        public SeLinuxInfoNormal mergeFrom(CodedInputByteBufferNano input) throws IOException {
            while (true) {
                int tag = input.readTag();
                switch (tag) {
                    case 0:
                        break;
                    case 8:
                        this.present = input.readBool();
                        continue;
                    case 16:
                        this.enforcing = input.readBool();
                        continue;
                    default:
                        if (!super.storeUnknownField(input, tag)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public static SeLinuxInfoNormal parseFrom(byte[] data) throws InvalidProtocolBufferNanoException {
            return (SeLinuxInfoNormal) MessageNano.mergeFrom(new SeLinuxInfoNormal(), data);
        }

        public static SeLinuxInfoNormal parseFrom(CodedInputByteBufferNano input) throws IOException {
            return new SeLinuxInfoNormal().mergeFrom(input);
        }
    }

    public static final class SetuidFileInfoNormal extends ExtendableMessageNano<SetuidFileInfoNormal> {
        private static volatile SetuidFileInfoNormal[] _emptyArray;
        public boolean couldNotCheck;
        public FileInfo[] fileInfo;
        public String[] filePaths;
        public long numberOfSetuidFiles;

        public static final class FileInfo extends ExtendableMessageNano<FileInfo> {
            private static volatile FileInfo[] _emptyArray;
            public String path;
            public byte[] sha256;

            public static FileInfo[] emptyArray() {
                if (_emptyArray == null) {
                    synchronized (InternalNano.LAZY_INIT_LOCK) {
                        if (_emptyArray == null) {
                            _emptyArray = new FileInfo[0];
                        }
                    }
                }
                return _emptyArray;
            }

            public FileInfo() {
                clear();
            }

            public FileInfo clear() {
                this.path = "";
                this.sha256 = WireFormatNano.EMPTY_BYTES;
                this.unknownFieldData = null;
                this.cachedSize = -1;
                return this;
            }

            public boolean equals(Object o) {
                if (o == this) {
                    return true;
                }
                if (!(o instanceof FileInfo)) {
                    return false;
                }
                FileInfo other = (FileInfo) o;
                if (this.path == null) {
                    if (other.path != null) {
                        return false;
                    }
                } else if (!this.path.equals(other.path)) {
                    return false;
                }
                if (!Arrays.equals(this.sha256, other.sha256)) {
                    return false;
                }
                if (this.unknownFieldData != null && !this.unknownFieldData.isEmpty()) {
                    return this.unknownFieldData.equals(other.unknownFieldData);
                }
                if (other.unknownFieldData == null || other.unknownFieldData.isEmpty()) {
                    return true;
                }
                return false;
            }

            public int hashCode() {
                int i;
                int i2 = 0;
                int hashCode = (getClass().getName().hashCode() + 527) * 31;
                if (this.path == null) {
                    i = 0;
                } else {
                    i = this.path.hashCode();
                }
                i = (((hashCode + i) * 31) + Arrays.hashCode(this.sha256)) * 31;
                if (!(this.unknownFieldData == null || this.unknownFieldData.isEmpty())) {
                    i2 = this.unknownFieldData.hashCode();
                }
                return i + i2;
            }

            public void writeTo(CodedOutputByteBufferNano output) throws IOException {
                if (!(this.path == null || this.path.equals(""))) {
                    output.writeString(1, this.path);
                }
                if (!Arrays.equals(this.sha256, WireFormatNano.EMPTY_BYTES)) {
                    output.writeBytes(2, this.sha256);
                }
                super.writeTo(output);
            }

            protected int computeSerializedSize() {
                int size = super.computeSerializedSize();
                if (!(this.path == null || this.path.equals(""))) {
                    size += CodedOutputByteBufferNano.computeStringSize(1, this.path);
                }
                if (Arrays.equals(this.sha256, WireFormatNano.EMPTY_BYTES)) {
                    return size;
                }
                return size + CodedOutputByteBufferNano.computeBytesSize(2, this.sha256);
            }

            public FileInfo mergeFrom(CodedInputByteBufferNano input) throws IOException {
                while (true) {
                    int tag = input.readTag();
                    switch (tag) {
                        case 0:
                            break;
                        case 10:
                            this.path = input.readString();
                            continue;
                        case 18:
                            this.sha256 = input.readBytes();
                            continue;
                        default:
                            if (!super.storeUnknownField(input, tag)) {
                                break;
                            }
                            continue;
                    }
                    return this;
                }
            }

            public static FileInfo parseFrom(byte[] data) throws InvalidProtocolBufferNanoException {
                return (FileInfo) MessageNano.mergeFrom(new FileInfo(), data);
            }

            public static FileInfo parseFrom(CodedInputByteBufferNano input) throws IOException {
                return new FileInfo().mergeFrom(input);
            }
        }

        public static SetuidFileInfoNormal[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new SetuidFileInfoNormal[0];
                    }
                }
            }
            return _emptyArray;
        }

        public SetuidFileInfoNormal() {
            clear();
        }

        public SetuidFileInfoNormal clear() {
            this.couldNotCheck = false;
            this.numberOfSetuidFiles = 0;
            this.filePaths = WireFormatNano.EMPTY_STRING_ARRAY;
            this.fileInfo = FileInfo.emptyArray();
            this.unknownFieldData = null;
            this.cachedSize = -1;
            return this;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof SetuidFileInfoNormal)) {
                return false;
            }
            SetuidFileInfoNormal other = (SetuidFileInfoNormal) o;
            if (this.couldNotCheck != other.couldNotCheck || this.numberOfSetuidFiles != other.numberOfSetuidFiles || !InternalNano.equals(this.filePaths, other.filePaths) || !InternalNano.equals(this.fileInfo, other.fileInfo)) {
                return false;
            }
            if (this.unknownFieldData != null && !this.unknownFieldData.isEmpty()) {
                return this.unknownFieldData.equals(other.unknownFieldData);
            }
            if (other.unknownFieldData == null || other.unknownFieldData.isEmpty()) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int i;
            int hashCode = (((((((((getClass().getName().hashCode() + 527) * 31) + (this.couldNotCheck ? 1231 : 1237)) * 31) + ((int) (this.numberOfSetuidFiles ^ (this.numberOfSetuidFiles >>> 32)))) * 31) + InternalNano.hashCode(this.filePaths)) * 31) + InternalNano.hashCode(this.fileInfo)) * 31;
            if (this.unknownFieldData == null || this.unknownFieldData.isEmpty()) {
                i = 0;
            } else {
                i = this.unknownFieldData.hashCode();
            }
            return hashCode + i;
        }

        public void writeTo(CodedOutputByteBufferNano output) throws IOException {
            if (this.couldNotCheck) {
                output.writeBool(1, this.couldNotCheck);
            }
            if (this.numberOfSetuidFiles != 0) {
                output.writeInt64(2, this.numberOfSetuidFiles);
            }
            if (this.filePaths != null && this.filePaths.length > 0) {
                for (String element : this.filePaths) {
                    if (element != null) {
                        output.writeString(3, element);
                    }
                }
            }
            if (this.fileInfo != null && this.fileInfo.length > 0) {
                for (FileInfo element2 : this.fileInfo) {
                    if (element2 != null) {
                        output.writeMessage(4, element2);
                    }
                }
            }
            super.writeTo(output);
        }

        protected int computeSerializedSize() {
            int size = super.computeSerializedSize();
            if (this.couldNotCheck) {
                size += CodedOutputByteBufferNano.computeBoolSize(1, this.couldNotCheck);
            }
            if (this.numberOfSetuidFiles != 0) {
                size += CodedOutputByteBufferNano.computeInt64Size(2, this.numberOfSetuidFiles);
            }
            if (this.filePaths != null && this.filePaths.length > 0) {
                int dataCount = 0;
                int dataSize = 0;
                for (String element : this.filePaths) {
                    if (element != null) {
                        dataCount++;
                        dataSize += CodedOutputByteBufferNano.computeStringSizeNoTag(element);
                    }
                }
                size = (size + dataSize) + (dataCount * 1);
            }
            if (this.fileInfo != null && this.fileInfo.length > 0) {
                for (FileInfo element2 : this.fileInfo) {
                    if (element2 != null) {
                        size += CodedOutputByteBufferNano.computeMessageSize(4, element2);
                    }
                }
            }
            return size;
        }

        public SetuidFileInfoNormal mergeFrom(CodedInputByteBufferNano input) throws IOException {
            while (true) {
                int tag = input.readTag();
                int arrayLength;
                int i;
                switch (tag) {
                    case 0:
                        break;
                    case 8:
                        this.couldNotCheck = input.readBool();
                        continue;
                    case 16:
                        this.numberOfSetuidFiles = input.readInt64();
                        continue;
                    case LogSource.ANDROID_CAMERA /*26*/:
                        arrayLength = WireFormatNano.getRepeatedFieldArrayLength(input, 26);
                        i = this.filePaths == null ? 0 : this.filePaths.length;
                        String[] newArray = new String[(i + arrayLength)];
                        if (i != 0) {
                            System.arraycopy(this.filePaths, 0, newArray, 0, i);
                        }
                        while (i < newArray.length - 1) {
                            newArray[i] = input.readString();
                            input.readTag();
                            i++;
                        }
                        newArray[i] = input.readString();
                        this.filePaths = newArray;
                        continue;
                    case 34:
                        arrayLength = WireFormatNano.getRepeatedFieldArrayLength(input, 34);
                        if (this.fileInfo == null) {
                            i = 0;
                        } else {
                            i = this.fileInfo.length;
                        }
                        FileInfo[] newArray2 = new FileInfo[(i + arrayLength)];
                        if (i != 0) {
                            System.arraycopy(this.fileInfo, 0, newArray2, 0, i);
                        }
                        while (i < newArray2.length - 1) {
                            newArray2[i] = new FileInfo();
                            input.readMessage(newArray2[i]);
                            input.readTag();
                            i++;
                        }
                        newArray2[i] = new FileInfo();
                        input.readMessage(newArray2[i]);
                        this.fileInfo = newArray2;
                        continue;
                    default:
                        if (!super.storeUnknownField(input, tag)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public static SetuidFileInfoNormal parseFrom(byte[] data) throws InvalidProtocolBufferNanoException {
            return (SetuidFileInfoNormal) MessageNano.mergeFrom(new SetuidFileInfoNormal(), data);
        }

        public static SetuidFileInfoNormal parseFrom(CodedInputByteBufferNano input) throws IOException {
            return new SetuidFileInfoNormal().mergeFrom(input);
        }
    }

    public static final class SnetLog extends ExtendableMessageNano<SnetLog> {
        private static volatile SnetLog[] _emptyArray;
        public AppsList appsList;
        public AttestationResult attestationResult;
        public String buildFingerprint;
        public CaptivePortalTestResults captivePortalTestResults;
        public CarrierInfo carrierInfo;
        public ConnectionInfo connectionInfo;
        public String country;
        public AppInfoNormal[] deactivatedDeviceAdmins;
        public String debugStatus;
        public DeviceStateNormal deviceState;
        public DnsMxRecords[] dnsMxRecords;
        public EventLogNormal[] events;
        public byte[] featuresBitField;
        public FilePresence[] files;
        public long firstEventLogTimeNano;
        public AppInfoNormal gmsCoreInfo;
        public boolean gmsCoreUuidUsed;
        public String googleWebpageHtml;
        public GoogleWebpageInfo googleWebpageInfo;
        public String[] invalidBlacklistedDeviceAdmins;
        public boolean isSidewinderDevice;
        public String[] jarExceptions;
        public long jarVersion;
        public String locale;
        public LogcatResultsNormal logcatResults;
        public PackageInfo preferredBrowser;
        public PackageInfo preferredInstaller;
        public String proxyAddress;
        public ProxyInfo proxyInfo;
        public RunSettingsNormal runSettings;
        public boolean sdCardTampered;
        public SdCardInfo sdCardTamperedInfo;
        public SeLinuxInfoNormal seLinuxInfo;
        public DeviceSettings settings;
        public SetuidFileInfoNormal setuidFileInfo;
        public String sharedUuid;
        public String signalTagsWhitelist;
        public SslHandshakeInfo[] sslHandshakeList;
        public SslRedirectInfo[] sslRedirectList;
        public OkHttpSslv3FallbackInfo sslv3Fallback;
        public SystemPartitionFileInfoNormal systemPartitionFileInfo;
        public String uuid;

        public static SnetLog[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new SnetLog[0];
                    }
                }
            }
            return _emptyArray;
        }

        public SnetLog() {
            clear();
        }

        public SnetLog clear() {
            this.jarVersion = 0;
            this.uuid = "";
            this.gmsCoreUuidUsed = false;
            this.sharedUuid = "";
            this.jarExceptions = WireFormatNano.EMPTY_STRING_ARRAY;
            this.featuresBitField = WireFormatNano.EMPTY_BYTES;
            this.debugStatus = "";
            this.runSettings = null;
            this.signalTagsWhitelist = "";
            this.isSidewinderDevice = false;
            this.locale = "";
            this.country = "";
            this.preferredBrowser = null;
            this.preferredInstaller = null;
            this.files = FilePresence.emptyArray();
            this.settings = null;
            this.setuidFileInfo = null;
            this.seLinuxInfo = null;
            this.systemPartitionFileInfo = null;
            this.deviceState = null;
            this.gmsCoreInfo = null;
            this.connectionInfo = null;
            this.sslRedirectList = SslRedirectInfo.emptyArray();
            this.sslHandshakeList = SslHandshakeInfo.emptyArray();
            this.googleWebpageHtml = "";
            this.googleWebpageInfo = null;
            this.sslv3Fallback = null;
            this.dnsMxRecords = DnsMxRecords.emptyArray();
            this.captivePortalTestResults = null;
            this.proxyAddress = "";
            this.proxyInfo = null;
            this.firstEventLogTimeNano = 0;
            this.events = EventLogNormal.emptyArray();
            this.carrierInfo = null;
            this.sdCardTampered = false;
            this.sdCardTamperedInfo = null;
            this.appsList = null;
            this.deactivatedDeviceAdmins = AppInfoNormal.emptyArray();
            this.invalidBlacklistedDeviceAdmins = WireFormatNano.EMPTY_STRING_ARRAY;
            this.logcatResults = null;
            this.buildFingerprint = "";
            this.attestationResult = null;
            this.unknownFieldData = null;
            this.cachedSize = -1;
            return this;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof SnetLog)) {
                return false;
            }
            SnetLog other = (SnetLog) o;
            if (this.jarVersion != other.jarVersion) {
                return false;
            }
            if (this.uuid == null) {
                if (other.uuid != null) {
                    return false;
                }
            } else if (!this.uuid.equals(other.uuid)) {
                return false;
            }
            if (this.gmsCoreUuidUsed != other.gmsCoreUuidUsed) {
                return false;
            }
            if (this.sharedUuid == null) {
                if (other.sharedUuid != null) {
                    return false;
                }
            } else if (!this.sharedUuid.equals(other.sharedUuid)) {
                return false;
            }
            if (!InternalNano.equals(this.jarExceptions, other.jarExceptions) || !Arrays.equals(this.featuresBitField, other.featuresBitField)) {
                return false;
            }
            if (this.debugStatus == null) {
                if (other.debugStatus != null) {
                    return false;
                }
            } else if (!this.debugStatus.equals(other.debugStatus)) {
                return false;
            }
            if (this.runSettings == null) {
                if (other.runSettings != null) {
                    return false;
                }
            } else if (!this.runSettings.equals(other.runSettings)) {
                return false;
            }
            if (this.signalTagsWhitelist == null) {
                if (other.signalTagsWhitelist != null) {
                    return false;
                }
            } else if (!this.signalTagsWhitelist.equals(other.signalTagsWhitelist)) {
                return false;
            }
            if (this.isSidewinderDevice != other.isSidewinderDevice) {
                return false;
            }
            if (this.locale == null) {
                if (other.locale != null) {
                    return false;
                }
            } else if (!this.locale.equals(other.locale)) {
                return false;
            }
            if (this.country == null) {
                if (other.country != null) {
                    return false;
                }
            } else if (!this.country.equals(other.country)) {
                return false;
            }
            if (this.preferredBrowser == null) {
                if (other.preferredBrowser != null) {
                    return false;
                }
            } else if (!this.preferredBrowser.equals(other.preferredBrowser)) {
                return false;
            }
            if (this.preferredInstaller == null) {
                if (other.preferredInstaller != null) {
                    return false;
                }
            } else if (!this.preferredInstaller.equals(other.preferredInstaller)) {
                return false;
            }
            if (!InternalNano.equals(this.files, other.files)) {
                return false;
            }
            if (this.settings == null) {
                if (other.settings != null) {
                    return false;
                }
            } else if (!this.settings.equals(other.settings)) {
                return false;
            }
            if (this.setuidFileInfo == null) {
                if (other.setuidFileInfo != null) {
                    return false;
                }
            } else if (!this.setuidFileInfo.equals(other.setuidFileInfo)) {
                return false;
            }
            if (this.seLinuxInfo == null) {
                if (other.seLinuxInfo != null) {
                    return false;
                }
            } else if (!this.seLinuxInfo.equals(other.seLinuxInfo)) {
                return false;
            }
            if (this.systemPartitionFileInfo == null) {
                if (other.systemPartitionFileInfo != null) {
                    return false;
                }
            } else if (!this.systemPartitionFileInfo.equals(other.systemPartitionFileInfo)) {
                return false;
            }
            if (this.deviceState == null) {
                if (other.deviceState != null) {
                    return false;
                }
            } else if (!this.deviceState.equals(other.deviceState)) {
                return false;
            }
            if (this.gmsCoreInfo == null) {
                if (other.gmsCoreInfo != null) {
                    return false;
                }
            } else if (!this.gmsCoreInfo.equals(other.gmsCoreInfo)) {
                return false;
            }
            if (this.connectionInfo == null) {
                if (other.connectionInfo != null) {
                    return false;
                }
            } else if (!this.connectionInfo.equals(other.connectionInfo)) {
                return false;
            }
            if (!InternalNano.equals(this.sslRedirectList, other.sslRedirectList) || !InternalNano.equals(this.sslHandshakeList, other.sslHandshakeList)) {
                return false;
            }
            if (this.googleWebpageHtml == null) {
                if (other.googleWebpageHtml != null) {
                    return false;
                }
            } else if (!this.googleWebpageHtml.equals(other.googleWebpageHtml)) {
                return false;
            }
            if (this.googleWebpageInfo == null) {
                if (other.googleWebpageInfo != null) {
                    return false;
                }
            } else if (!this.googleWebpageInfo.equals(other.googleWebpageInfo)) {
                return false;
            }
            if (this.sslv3Fallback == null) {
                if (other.sslv3Fallback != null) {
                    return false;
                }
            } else if (!this.sslv3Fallback.equals(other.sslv3Fallback)) {
                return false;
            }
            if (!InternalNano.equals(this.dnsMxRecords, other.dnsMxRecords)) {
                return false;
            }
            if (this.captivePortalTestResults == null) {
                if (other.captivePortalTestResults != null) {
                    return false;
                }
            } else if (!this.captivePortalTestResults.equals(other.captivePortalTestResults)) {
                return false;
            }
            if (this.proxyAddress == null) {
                if (other.proxyAddress != null) {
                    return false;
                }
            } else if (!this.proxyAddress.equals(other.proxyAddress)) {
                return false;
            }
            if (this.proxyInfo == null) {
                if (other.proxyInfo != null) {
                    return false;
                }
            } else if (!this.proxyInfo.equals(other.proxyInfo)) {
                return false;
            }
            if (this.firstEventLogTimeNano != other.firstEventLogTimeNano || !InternalNano.equals(this.events, other.events)) {
                return false;
            }
            if (this.carrierInfo == null) {
                if (other.carrierInfo != null) {
                    return false;
                }
            } else if (!this.carrierInfo.equals(other.carrierInfo)) {
                return false;
            }
            if (this.sdCardTampered != other.sdCardTampered) {
                return false;
            }
            if (this.sdCardTamperedInfo == null) {
                if (other.sdCardTamperedInfo != null) {
                    return false;
                }
            } else if (!this.sdCardTamperedInfo.equals(other.sdCardTamperedInfo)) {
                return false;
            }
            if (this.appsList == null) {
                if (other.appsList != null) {
                    return false;
                }
            } else if (!this.appsList.equals(other.appsList)) {
                return false;
            }
            if (!InternalNano.equals(this.deactivatedDeviceAdmins, other.deactivatedDeviceAdmins) || !InternalNano.equals(this.invalidBlacklistedDeviceAdmins, other.invalidBlacklistedDeviceAdmins)) {
                return false;
            }
            if (this.logcatResults == null) {
                if (other.logcatResults != null) {
                    return false;
                }
            } else if (!this.logcatResults.equals(other.logcatResults)) {
                return false;
            }
            if (this.buildFingerprint == null) {
                if (other.buildFingerprint != null) {
                    return false;
                }
            } else if (!this.buildFingerprint.equals(other.buildFingerprint)) {
                return false;
            }
            if (this.attestationResult == null) {
                if (other.attestationResult != null) {
                    return false;
                }
            } else if (!this.attestationResult.equals(other.attestationResult)) {
                return false;
            }
            if (this.unknownFieldData != null && !this.unknownFieldData.isEmpty()) {
                return this.unknownFieldData.equals(other.unknownFieldData);
            }
            if (other.unknownFieldData == null || other.unknownFieldData.isEmpty()) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int i;
            int i2 = 1231;
            int i3 = 0;
            int hashCode = (((getClass().getName().hashCode() + 527) * 31) + ((int) (this.jarVersion ^ (this.jarVersion >>> 32)))) * 31;
            if (this.uuid == null) {
                i = 0;
            } else {
                i = this.uuid.hashCode();
            }
            hashCode = (hashCode + i) * 31;
            if (this.gmsCoreUuidUsed) {
                i = 1231;
            } else {
                i = 1237;
            }
            hashCode = (hashCode + i) * 31;
            if (this.sharedUuid == null) {
                i = 0;
            } else {
                i = this.sharedUuid.hashCode();
            }
            hashCode = (((((hashCode + i) * 31) + InternalNano.hashCode(this.jarExceptions)) * 31) + Arrays.hashCode(this.featuresBitField)) * 31;
            if (this.debugStatus == null) {
                i = 0;
            } else {
                i = this.debugStatus.hashCode();
            }
            hashCode = (hashCode + i) * 31;
            if (this.runSettings == null) {
                i = 0;
            } else {
                i = this.runSettings.hashCode();
            }
            hashCode = (hashCode + i) * 31;
            if (this.signalTagsWhitelist == null) {
                i = 0;
            } else {
                i = this.signalTagsWhitelist.hashCode();
            }
            hashCode = (hashCode + i) * 31;
            if (this.isSidewinderDevice) {
                i = 1231;
            } else {
                i = 1237;
            }
            hashCode = (hashCode + i) * 31;
            if (this.locale == null) {
                i = 0;
            } else {
                i = this.locale.hashCode();
            }
            hashCode = (hashCode + i) * 31;
            if (this.country == null) {
                i = 0;
            } else {
                i = this.country.hashCode();
            }
            hashCode = (hashCode + i) * 31;
            if (this.preferredBrowser == null) {
                i = 0;
            } else {
                i = this.preferredBrowser.hashCode();
            }
            hashCode = (hashCode + i) * 31;
            if (this.preferredInstaller == null) {
                i = 0;
            } else {
                i = this.preferredInstaller.hashCode();
            }
            hashCode = (((hashCode + i) * 31) + InternalNano.hashCode(this.files)) * 31;
            if (this.settings == null) {
                i = 0;
            } else {
                i = this.settings.hashCode();
            }
            hashCode = (hashCode + i) * 31;
            if (this.setuidFileInfo == null) {
                i = 0;
            } else {
                i = this.setuidFileInfo.hashCode();
            }
            hashCode = (hashCode + i) * 31;
            if (this.seLinuxInfo == null) {
                i = 0;
            } else {
                i = this.seLinuxInfo.hashCode();
            }
            hashCode = (hashCode + i) * 31;
            if (this.systemPartitionFileInfo == null) {
                i = 0;
            } else {
                i = this.systemPartitionFileInfo.hashCode();
            }
            hashCode = (hashCode + i) * 31;
            if (this.deviceState == null) {
                i = 0;
            } else {
                i = this.deviceState.hashCode();
            }
            hashCode = (hashCode + i) * 31;
            if (this.gmsCoreInfo == null) {
                i = 0;
            } else {
                i = this.gmsCoreInfo.hashCode();
            }
            hashCode = (hashCode + i) * 31;
            if (this.connectionInfo == null) {
                i = 0;
            } else {
                i = this.connectionInfo.hashCode();
            }
            hashCode = (((((hashCode + i) * 31) + InternalNano.hashCode(this.sslRedirectList)) * 31) + InternalNano.hashCode(this.sslHandshakeList)) * 31;
            if (this.googleWebpageHtml == null) {
                i = 0;
            } else {
                i = this.googleWebpageHtml.hashCode();
            }
            hashCode = (hashCode + i) * 31;
            if (this.googleWebpageInfo == null) {
                i = 0;
            } else {
                i = this.googleWebpageInfo.hashCode();
            }
            hashCode = (hashCode + i) * 31;
            if (this.sslv3Fallback == null) {
                i = 0;
            } else {
                i = this.sslv3Fallback.hashCode();
            }
            hashCode = (((hashCode + i) * 31) + InternalNano.hashCode(this.dnsMxRecords)) * 31;
            if (this.captivePortalTestResults == null) {
                i = 0;
            } else {
                i = this.captivePortalTestResults.hashCode();
            }
            hashCode = (hashCode + i) * 31;
            if (this.proxyAddress == null) {
                i = 0;
            } else {
                i = this.proxyAddress.hashCode();
            }
            hashCode = (hashCode + i) * 31;
            if (this.proxyInfo == null) {
                i = 0;
            } else {
                i = this.proxyInfo.hashCode();
            }
            hashCode = (((((hashCode + i) * 31) + ((int) (this.firstEventLogTimeNano ^ (this.firstEventLogTimeNano >>> 32)))) * 31) + InternalNano.hashCode(this.events)) * 31;
            if (this.carrierInfo == null) {
                i = 0;
            } else {
                i = this.carrierInfo.hashCode();
            }
            i = (hashCode + i) * 31;
            if (!this.sdCardTampered) {
                i2 = 1237;
            }
            i2 = (i + i2) * 31;
            if (this.sdCardTamperedInfo == null) {
                i = 0;
            } else {
                i = this.sdCardTamperedInfo.hashCode();
            }
            i2 = (i2 + i) * 31;
            if (this.appsList == null) {
                i = 0;
            } else {
                i = this.appsList.hashCode();
            }
            i2 = (((((i2 + i) * 31) + InternalNano.hashCode(this.deactivatedDeviceAdmins)) * 31) + InternalNano.hashCode(this.invalidBlacklistedDeviceAdmins)) * 31;
            if (this.logcatResults == null) {
                i = 0;
            } else {
                i = this.logcatResults.hashCode();
            }
            i2 = (i2 + i) * 31;
            if (this.buildFingerprint == null) {
                i = 0;
            } else {
                i = this.buildFingerprint.hashCode();
            }
            i2 = (i2 + i) * 31;
            if (this.attestationResult == null) {
                i = 0;
            } else {
                i = this.attestationResult.hashCode();
            }
            i = (i2 + i) * 31;
            if (!(this.unknownFieldData == null || this.unknownFieldData.isEmpty())) {
                i3 = this.unknownFieldData.hashCode();
            }
            return i + i3;
        }

        public void writeTo(CodedOutputByteBufferNano output) throws IOException {
            if (this.jarVersion != 0) {
                output.writeInt64(1, this.jarVersion);
            }
            if (this.jarExceptions != null && this.jarExceptions.length > 0) {
                for (String element : this.jarExceptions) {
                    if (element != null) {
                        output.writeString(2, element);
                    }
                }
            }
            if (!(this.locale == null || this.locale.equals(""))) {
                output.writeString(3, this.locale);
            }
            if (this.preferredBrowser != null) {
                output.writeMessage(4, this.preferredBrowser);
            }
            if (this.preferredInstaller != null) {
                output.writeMessage(5, this.preferredInstaller);
            }
            if (this.files != null && this.files.length > 0) {
                for (FilePresence element2 : this.files) {
                    if (element2 != null) {
                        output.writeMessage(6, element2);
                    }
                }
            }
            if (this.settings != null) {
                output.writeMessage(7, this.settings);
            }
            if (this.connectionInfo != null) {
                output.writeMessage(8, this.connectionInfo);
            }
            if (this.sslRedirectList != null && this.sslRedirectList.length > 0) {
                for (SslRedirectInfo element3 : this.sslRedirectList) {
                    if (element3 != null) {
                        output.writeMessage(9, element3);
                    }
                }
            }
            if (this.sslHandshakeList != null && this.sslHandshakeList.length > 0) {
                for (SslHandshakeInfo element4 : this.sslHandshakeList) {
                    if (element4 != null) {
                        output.writeMessage(10, element4);
                    }
                }
            }
            if (this.events != null && this.events.length > 0) {
                for (EventLogNormal element5 : this.events) {
                    if (element5 != null) {
                        output.writeMessage(11, element5);
                    }
                }
            }
            if (!(this.proxyAddress == null || this.proxyAddress.equals(""))) {
                output.writeString(12, this.proxyAddress);
            }
            if (this.setuidFileInfo != null) {
                output.writeMessage(13, this.setuidFileInfo);
            }
            if (this.seLinuxInfo != null) {
                output.writeMessage(14, this.seLinuxInfo);
            }
            if (!(this.uuid == null || this.uuid.equals(""))) {
                output.writeString(15, this.uuid);
            }
            if (this.gmsCoreUuidUsed) {
                output.writeBool(16, this.gmsCoreUuidUsed);
            }
            if (this.sdCardTampered) {
                output.writeBool(17, this.sdCardTampered);
            }
            if (this.appsList != null) {
                output.writeMessage(18, this.appsList);
            }
            if (!(this.googleWebpageHtml == null || this.googleWebpageHtml.equals(""))) {
                output.writeString(19, this.googleWebpageHtml);
            }
            if (this.sslv3Fallback != null) {
                output.writeMessage(20, this.sslv3Fallback);
            }
            if (this.dnsMxRecords != null && this.dnsMxRecords.length > 0) {
                for (DnsMxRecords element6 : this.dnsMxRecords) {
                    if (element6 != null) {
                        output.writeMessage(21, element6);
                    }
                }
            }
            if (!Arrays.equals(this.featuresBitField, WireFormatNano.EMPTY_BYTES)) {
                output.writeBytes(22, this.featuresBitField);
            }
            if (this.sdCardTamperedInfo != null) {
                output.writeMessage(23, this.sdCardTamperedInfo);
            }
            if (!(this.debugStatus == null || this.debugStatus.equals(""))) {
                output.writeString(24, this.debugStatus);
            }
            if (this.runSettings != null) {
                output.writeMessage(25, this.runSettings);
            }
            if (this.googleWebpageInfo != null) {
                output.writeMessage(26, this.googleWebpageInfo);
            }
            if (this.captivePortalTestResults != null) {
                output.writeMessage(27, this.captivePortalTestResults);
            }
            if (this.proxyInfo != null) {
                output.writeMessage(28, this.proxyInfo);
            }
            if (this.logcatResults != null) {
                output.writeMessage(29, this.logcatResults);
            }
            if (this.systemPartitionFileInfo != null) {
                output.writeMessage(30, this.systemPartitionFileInfo);
            }
            if (!(this.buildFingerprint == null || this.buildFingerprint.equals(""))) {
                output.writeString(31, this.buildFingerprint);
            }
            if (!(this.signalTagsWhitelist == null || this.signalTagsWhitelist.equals(""))) {
                output.writeString(32, this.signalTagsWhitelist);
            }
            if (this.attestationResult != null) {
                output.writeMessage(33, this.attestationResult);
            }
            if (!(this.sharedUuid == null || this.sharedUuid.equals(""))) {
                output.writeString(34, this.sharedUuid);
            }
            if (this.gmsCoreInfo != null) {
                output.writeMessage(35, this.gmsCoreInfo);
            }
            if (this.firstEventLogTimeNano != 0) {
                output.writeInt64(36, this.firstEventLogTimeNano);
            }
            if (this.isSidewinderDevice) {
                output.writeBool(37, this.isSidewinderDevice);
            }
            if (this.deactivatedDeviceAdmins != null && this.deactivatedDeviceAdmins.length > 0) {
                for (AppInfoNormal element7 : this.deactivatedDeviceAdmins) {
                    if (element7 != null) {
                        output.writeMessage(38, element7);
                    }
                }
            }
            if (this.invalidBlacklistedDeviceAdmins != null && this.invalidBlacklistedDeviceAdmins.length > 0) {
                for (String element8 : this.invalidBlacklistedDeviceAdmins) {
                    if (element8 != null) {
                        output.writeString(39, element8);
                    }
                }
            }
            if (!(this.country == null || this.country.equals(""))) {
                output.writeString(40, this.country);
            }
            if (this.deviceState != null) {
                output.writeMessage(41, this.deviceState);
            }
            if (this.carrierInfo != null) {
                output.writeMessage(42, this.carrierInfo);
            }
            super.writeTo(output);
        }

        protected int computeSerializedSize() {
            int dataCount;
            int dataSize;
            int size = super.computeSerializedSize();
            if (this.jarVersion != 0) {
                size += CodedOutputByteBufferNano.computeInt64Size(1, this.jarVersion);
            }
            if (this.jarExceptions != null && this.jarExceptions.length > 0) {
                dataCount = 0;
                dataSize = 0;
                for (String element : this.jarExceptions) {
                    if (element != null) {
                        dataCount++;
                        dataSize += CodedOutputByteBufferNano.computeStringSizeNoTag(element);
                    }
                }
                size = (size + dataSize) + (dataCount * 1);
            }
            if (!(this.locale == null || this.locale.equals(""))) {
                size += CodedOutputByteBufferNano.computeStringSize(3, this.locale);
            }
            if (this.preferredBrowser != null) {
                size += CodedOutputByteBufferNano.computeMessageSize(4, this.preferredBrowser);
            }
            if (this.preferredInstaller != null) {
                size += CodedOutputByteBufferNano.computeMessageSize(5, this.preferredInstaller);
            }
            if (this.files != null && this.files.length > 0) {
                for (FilePresence element2 : this.files) {
                    if (element2 != null) {
                        size += CodedOutputByteBufferNano.computeMessageSize(6, element2);
                    }
                }
            }
            if (this.settings != null) {
                size += CodedOutputByteBufferNano.computeMessageSize(7, this.settings);
            }
            if (this.connectionInfo != null) {
                size += CodedOutputByteBufferNano.computeMessageSize(8, this.connectionInfo);
            }
            if (this.sslRedirectList != null && this.sslRedirectList.length > 0) {
                for (SslRedirectInfo element3 : this.sslRedirectList) {
                    if (element3 != null) {
                        size += CodedOutputByteBufferNano.computeMessageSize(9, element3);
                    }
                }
            }
            if (this.sslHandshakeList != null && this.sslHandshakeList.length > 0) {
                for (SslHandshakeInfo element4 : this.sslHandshakeList) {
                    if (element4 != null) {
                        size += CodedOutputByteBufferNano.computeMessageSize(10, element4);
                    }
                }
            }
            if (this.events != null && this.events.length > 0) {
                for (EventLogNormal element5 : this.events) {
                    if (element5 != null) {
                        size += CodedOutputByteBufferNano.computeMessageSize(11, element5);
                    }
                }
            }
            if (!(this.proxyAddress == null || this.proxyAddress.equals(""))) {
                size += CodedOutputByteBufferNano.computeStringSize(12, this.proxyAddress);
            }
            if (this.setuidFileInfo != null) {
                size += CodedOutputByteBufferNano.computeMessageSize(13, this.setuidFileInfo);
            }
            if (this.seLinuxInfo != null) {
                size += CodedOutputByteBufferNano.computeMessageSize(14, this.seLinuxInfo);
            }
            if (!(this.uuid == null || this.uuid.equals(""))) {
                size += CodedOutputByteBufferNano.computeStringSize(15, this.uuid);
            }
            if (this.gmsCoreUuidUsed) {
                size += CodedOutputByteBufferNano.computeBoolSize(16, this.gmsCoreUuidUsed);
            }
            if (this.sdCardTampered) {
                size += CodedOutputByteBufferNano.computeBoolSize(17, this.sdCardTampered);
            }
            if (this.appsList != null) {
                size += CodedOutputByteBufferNano.computeMessageSize(18, this.appsList);
            }
            if (!(this.googleWebpageHtml == null || this.googleWebpageHtml.equals(""))) {
                size += CodedOutputByteBufferNano.computeStringSize(19, this.googleWebpageHtml);
            }
            if (this.sslv3Fallback != null) {
                size += CodedOutputByteBufferNano.computeMessageSize(20, this.sslv3Fallback);
            }
            if (this.dnsMxRecords != null && this.dnsMxRecords.length > 0) {
                for (DnsMxRecords element6 : this.dnsMxRecords) {
                    if (element6 != null) {
                        size += CodedOutputByteBufferNano.computeMessageSize(21, element6);
                    }
                }
            }
            if (!Arrays.equals(this.featuresBitField, WireFormatNano.EMPTY_BYTES)) {
                size += CodedOutputByteBufferNano.computeBytesSize(22, this.featuresBitField);
            }
            if (this.sdCardTamperedInfo != null) {
                size += CodedOutputByteBufferNano.computeMessageSize(23, this.sdCardTamperedInfo);
            }
            if (!(this.debugStatus == null || this.debugStatus.equals(""))) {
                size += CodedOutputByteBufferNano.computeStringSize(24, this.debugStatus);
            }
            if (this.runSettings != null) {
                size += CodedOutputByteBufferNano.computeMessageSize(25, this.runSettings);
            }
            if (this.googleWebpageInfo != null) {
                size += CodedOutputByteBufferNano.computeMessageSize(26, this.googleWebpageInfo);
            }
            if (this.captivePortalTestResults != null) {
                size += CodedOutputByteBufferNano.computeMessageSize(27, this.captivePortalTestResults);
            }
            if (this.proxyInfo != null) {
                size += CodedOutputByteBufferNano.computeMessageSize(28, this.proxyInfo);
            }
            if (this.logcatResults != null) {
                size += CodedOutputByteBufferNano.computeMessageSize(29, this.logcatResults);
            }
            if (this.systemPartitionFileInfo != null) {
                size += CodedOutputByteBufferNano.computeMessageSize(30, this.systemPartitionFileInfo);
            }
            if (!(this.buildFingerprint == null || this.buildFingerprint.equals(""))) {
                size += CodedOutputByteBufferNano.computeStringSize(31, this.buildFingerprint);
            }
            if (!(this.signalTagsWhitelist == null || this.signalTagsWhitelist.equals(""))) {
                size += CodedOutputByteBufferNano.computeStringSize(32, this.signalTagsWhitelist);
            }
            if (this.attestationResult != null) {
                size += CodedOutputByteBufferNano.computeMessageSize(33, this.attestationResult);
            }
            if (!(this.sharedUuid == null || this.sharedUuid.equals(""))) {
                size += CodedOutputByteBufferNano.computeStringSize(34, this.sharedUuid);
            }
            if (this.gmsCoreInfo != null) {
                size += CodedOutputByteBufferNano.computeMessageSize(35, this.gmsCoreInfo);
            }
            if (this.firstEventLogTimeNano != 0) {
                size += CodedOutputByteBufferNano.computeInt64Size(36, this.firstEventLogTimeNano);
            }
            if (this.isSidewinderDevice) {
                size += CodedOutputByteBufferNano.computeBoolSize(37, this.isSidewinderDevice);
            }
            if (this.deactivatedDeviceAdmins != null && this.deactivatedDeviceAdmins.length > 0) {
                for (AppInfoNormal element7 : this.deactivatedDeviceAdmins) {
                    if (element7 != null) {
                        size += CodedOutputByteBufferNano.computeMessageSize(38, element7);
                    }
                }
            }
            if (this.invalidBlacklistedDeviceAdmins != null && this.invalidBlacklistedDeviceAdmins.length > 0) {
                dataCount = 0;
                dataSize = 0;
                for (String element8 : this.invalidBlacklistedDeviceAdmins) {
                    if (element8 != null) {
                        dataCount++;
                        dataSize += CodedOutputByteBufferNano.computeStringSizeNoTag(element8);
                    }
                }
                size = (size + dataSize) + (dataCount * 2);
            }
            if (!(this.country == null || this.country.equals(""))) {
                size += CodedOutputByteBufferNano.computeStringSize(40, this.country);
            }
            if (this.deviceState != null) {
                size += CodedOutputByteBufferNano.computeMessageSize(41, this.deviceState);
            }
            if (this.carrierInfo != null) {
                return size + CodedOutputByteBufferNano.computeMessageSize(42, this.carrierInfo);
            }
            return size;
        }

        public SnetLog mergeFrom(CodedInputByteBufferNano input) throws IOException {
            while (true) {
                int tag = input.readTag();
                int arrayLength;
                int i;
                String[] newArray;
                switch (tag) {
                    case 0:
                        break;
                    case 8:
                        this.jarVersion = input.readInt64();
                        continue;
                    case 18:
                        arrayLength = WireFormatNano.getRepeatedFieldArrayLength(input, 18);
                        i = this.jarExceptions == null ? 0 : this.jarExceptions.length;
                        newArray = new String[(i + arrayLength)];
                        if (i != 0) {
                            System.arraycopy(this.jarExceptions, 0, newArray, 0, i);
                        }
                        while (i < newArray.length - 1) {
                            newArray[i] = input.readString();
                            input.readTag();
                            i++;
                        }
                        newArray[i] = input.readString();
                        this.jarExceptions = newArray;
                        continue;
                    case LogSource.ANDROID_CAMERA /*26*/:
                        this.locale = input.readString();
                        continue;
                    case 34:
                        if (this.preferredBrowser == null) {
                            this.preferredBrowser = new PackageInfo();
                        }
                        input.readMessage(this.preferredBrowser);
                        continue;
                    case MotionEventCompat.AXIS_GENERIC_11 /*42*/:
                        if (this.preferredInstaller == null) {
                            this.preferredInstaller = new PackageInfo();
                        }
                        input.readMessage(this.preferredInstaller);
                        continue;
                    case 50:
                        arrayLength = WireFormatNano.getRepeatedFieldArrayLength(input, 50);
                        if (this.files == null) {
                            i = 0;
                        } else {
                            i = this.files.length;
                        }
                        FilePresence[] newArray2 = new FilePresence[(i + arrayLength)];
                        if (i != 0) {
                            System.arraycopy(this.files, 0, newArray2, 0, i);
                        }
                        while (i < newArray2.length - 1) {
                            newArray2[i] = new FilePresence();
                            input.readMessage(newArray2[i]);
                            input.readTag();
                            i++;
                        }
                        newArray2[i] = new FilePresence();
                        input.readMessage(newArray2[i]);
                        this.files = newArray2;
                        continue;
                    case 58:
                        if (this.settings == null) {
                            this.settings = new DeviceSettings();
                        }
                        input.readMessage(this.settings);
                        continue;
                    case 66:
                        if (this.connectionInfo == null) {
                            this.connectionInfo = new ConnectionInfo();
                        }
                        input.readMessage(this.connectionInfo);
                        continue;
                    case 74:
                        arrayLength = WireFormatNano.getRepeatedFieldArrayLength(input, 74);
                        if (this.sslRedirectList == null) {
                            i = 0;
                        } else {
                            i = this.sslRedirectList.length;
                        }
                        SslRedirectInfo[] newArray3 = new SslRedirectInfo[(i + arrayLength)];
                        if (i != 0) {
                            System.arraycopy(this.sslRedirectList, 0, newArray3, 0, i);
                        }
                        while (i < newArray3.length - 1) {
                            newArray3[i] = new SslRedirectInfo();
                            input.readMessage(newArray3[i]);
                            input.readTag();
                            i++;
                        }
                        newArray3[i] = new SslRedirectInfo();
                        input.readMessage(newArray3[i]);
                        this.sslRedirectList = newArray3;
                        continue;
                    case 82:
                        arrayLength = WireFormatNano.getRepeatedFieldArrayLength(input, 82);
                        if (this.sslHandshakeList == null) {
                            i = 0;
                        } else {
                            i = this.sslHandshakeList.length;
                        }
                        SslHandshakeInfo[] newArray4 = new SslHandshakeInfo[(i + arrayLength)];
                        if (i != 0) {
                            System.arraycopy(this.sslHandshakeList, 0, newArray4, 0, i);
                        }
                        while (i < newArray4.length - 1) {
                            newArray4[i] = new SslHandshakeInfo();
                            input.readMessage(newArray4[i]);
                            input.readTag();
                            i++;
                        }
                        newArray4[i] = new SslHandshakeInfo();
                        input.readMessage(newArray4[i]);
                        this.sslHandshakeList = newArray4;
                        continue;
                    case 90:
                        arrayLength = WireFormatNano.getRepeatedFieldArrayLength(input, 90);
                        if (this.events == null) {
                            i = 0;
                        } else {
                            i = this.events.length;
                        }
                        EventLogNormal[] newArray5 = new EventLogNormal[(i + arrayLength)];
                        if (i != 0) {
                            System.arraycopy(this.events, 0, newArray5, 0, i);
                        }
                        while (i < newArray5.length - 1) {
                            newArray5[i] = new EventLogNormal();
                            input.readMessage(newArray5[i]);
                            input.readTag();
                            i++;
                        }
                        newArray5[i] = new EventLogNormal();
                        input.readMessage(newArray5[i]);
                        this.events = newArray5;
                        continue;
                    case 98:
                        this.proxyAddress = input.readString();
                        continue;
                    case 106:
                        if (this.setuidFileInfo == null) {
                            this.setuidFileInfo = new SetuidFileInfoNormal();
                        }
                        input.readMessage(this.setuidFileInfo);
                        continue;
                    case 114:
                        if (this.seLinuxInfo == null) {
                            this.seLinuxInfo = new SeLinuxInfoNormal();
                        }
                        input.readMessage(this.seLinuxInfo);
                        continue;
                    case 122:
                        this.uuid = input.readString();
                        continue;
                    case 128:
                        this.gmsCoreUuidUsed = input.readBool();
                        continue;
                    case 136:
                        this.sdCardTampered = input.readBool();
                        continue;
                    case 146:
                        if (this.appsList == null) {
                            this.appsList = new AppsList();
                        }
                        input.readMessage(this.appsList);
                        continue;
                    case 154:
                        this.googleWebpageHtml = input.readString();
                        continue;
                    case 162:
                        if (this.sslv3Fallback == null) {
                            this.sslv3Fallback = new OkHttpSslv3FallbackInfo();
                        }
                        input.readMessage(this.sslv3Fallback);
                        continue;
                    case 170:
                        arrayLength = WireFormatNano.getRepeatedFieldArrayLength(input, 170);
                        if (this.dnsMxRecords == null) {
                            i = 0;
                        } else {
                            i = this.dnsMxRecords.length;
                        }
                        DnsMxRecords[] newArray6 = new DnsMxRecords[(i + arrayLength)];
                        if (i != 0) {
                            System.arraycopy(this.dnsMxRecords, 0, newArray6, 0, i);
                        }
                        while (i < newArray6.length - 1) {
                            newArray6[i] = new DnsMxRecords();
                            input.readMessage(newArray6[i]);
                            input.readTag();
                            i++;
                        }
                        newArray6[i] = new DnsMxRecords();
                        input.readMessage(newArray6[i]);
                        this.dnsMxRecords = newArray6;
                        continue;
                    case 178:
                        this.featuresBitField = input.readBytes();
                        continue;
                    case 186:
                        if (this.sdCardTamperedInfo == null) {
                            this.sdCardTamperedInfo = new SdCardInfo();
                        }
                        input.readMessage(this.sdCardTamperedInfo);
                        continue;
                    case 194:
                        this.debugStatus = input.readString();
                        continue;
                    case 202:
                        if (this.runSettings == null) {
                            this.runSettings = new RunSettingsNormal();
                        }
                        input.readMessage(this.runSettings);
                        continue;
                    case 210:
                        if (this.googleWebpageInfo == null) {
                            this.googleWebpageInfo = new GoogleWebpageInfo();
                        }
                        input.readMessage(this.googleWebpageInfo);
                        continue;
                    case 218:
                        if (this.captivePortalTestResults == null) {
                            this.captivePortalTestResults = new CaptivePortalTestResults();
                        }
                        input.readMessage(this.captivePortalTestResults);
                        continue;
                    case 226:
                        if (this.proxyInfo == null) {
                            this.proxyInfo = new ProxyInfo();
                        }
                        input.readMessage(this.proxyInfo);
                        continue;
                    case 234:
                        if (this.logcatResults == null) {
                            this.logcatResults = new LogcatResultsNormal();
                        }
                        input.readMessage(this.logcatResults);
                        continue;
                    case 242:
                        if (this.systemPartitionFileInfo == null) {
                            this.systemPartitionFileInfo = new SystemPartitionFileInfoNormal();
                        }
                        input.readMessage(this.systemPartitionFileInfo);
                        continue;
                    case 250:
                        this.buildFingerprint = input.readString();
                        continue;
                    case 258:
                        this.signalTagsWhitelist = input.readString();
                        continue;
                    case 266:
                        if (this.attestationResult == null) {
                            this.attestationResult = new AttestationResult();
                        }
                        input.readMessage(this.attestationResult);
                        continue;
                    case 274:
                        this.sharedUuid = input.readString();
                        continue;
                    case 282:
                        if (this.gmsCoreInfo == null) {
                            this.gmsCoreInfo = new AppInfoNormal();
                        }
                        input.readMessage(this.gmsCoreInfo);
                        continue;
                    case 288:
                        this.firstEventLogTimeNano = input.readInt64();
                        continue;
                    case 296:
                        this.isSidewinderDevice = input.readBool();
                        continue;
                    case 306:
                        arrayLength = WireFormatNano.getRepeatedFieldArrayLength(input, 306);
                        if (this.deactivatedDeviceAdmins == null) {
                            i = 0;
                        } else {
                            i = this.deactivatedDeviceAdmins.length;
                        }
                        AppInfoNormal[] newArray7 = new AppInfoNormal[(i + arrayLength)];
                        if (i != 0) {
                            System.arraycopy(this.deactivatedDeviceAdmins, 0, newArray7, 0, i);
                        }
                        while (i < newArray7.length - 1) {
                            newArray7[i] = new AppInfoNormal();
                            input.readMessage(newArray7[i]);
                            input.readTag();
                            i++;
                        }
                        newArray7[i] = new AppInfoNormal();
                        input.readMessage(newArray7[i]);
                        this.deactivatedDeviceAdmins = newArray7;
                        continue;
                    case 314:
                        arrayLength = WireFormatNano.getRepeatedFieldArrayLength(input, 314);
                        i = this.invalidBlacklistedDeviceAdmins == null ? 0 : this.invalidBlacklistedDeviceAdmins.length;
                        newArray = new String[(i + arrayLength)];
                        if (i != 0) {
                            System.arraycopy(this.invalidBlacklistedDeviceAdmins, 0, newArray, 0, i);
                        }
                        while (i < newArray.length - 1) {
                            newArray[i] = input.readString();
                            input.readTag();
                            i++;
                        }
                        newArray[i] = input.readString();
                        this.invalidBlacklistedDeviceAdmins = newArray;
                        continue;
                    case 322:
                        this.country = input.readString();
                        continue;
                    case 330:
                        if (this.deviceState == null) {
                            this.deviceState = new DeviceStateNormal();
                        }
                        input.readMessage(this.deviceState);
                        continue;
                    case 338:
                        if (this.carrierInfo == null) {
                            this.carrierInfo = new CarrierInfo();
                        }
                        input.readMessage(this.carrierInfo);
                        continue;
                    default:
                        if (!super.storeUnknownField(input, tag)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public static SnetLog parseFrom(byte[] data) throws InvalidProtocolBufferNanoException {
            return (SnetLog) MessageNano.mergeFrom(new SnetLog(), data);
        }

        public static SnetLog parseFrom(CodedInputByteBufferNano input) throws IOException {
            return new SnetLog().mergeFrom(input);
        }
    }

    public static final class SslHandshakeInfo extends ExtendableMessageNano<SslHandshakeInfo> {
        private static volatile SslHandshakeInfo[] _emptyArray;
        public boolean certInCaStore;
        public boolean certUserAdded;
        public boolean chainTrusted;
        public boolean chainTrustedByPubkey;
        public boolean chainValid;
        public String cipherSuite;
        public boolean extendedKeyUsageFieldValid;
        public String host;
        public boolean hostnameVerified;
        public byte[][] peerCertificates;
        public boolean peerCertificatesAcquired;
        public boolean pinTestError;
        public String protocol;
        public boolean sessionEstablished;
        public boolean socketCreated;
        public int sslConnectionMethod;
        public boolean sslConnectionSucceeded;
        public boolean systemTrustManagerAcceptedConnection;
        public boolean systemTrustManagerExists;
        public TrustManagerInfo[] trustManagers;

        public static SslHandshakeInfo[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new SslHandshakeInfo[0];
                    }
                }
            }
            return _emptyArray;
        }

        public SslHandshakeInfo() {
            clear();
        }

        public SslHandshakeInfo clear() {
            this.sslConnectionMethod = 0;
            this.host = "";
            this.socketCreated = false;
            this.sslConnectionSucceeded = false;
            this.sessionEstablished = false;
            this.protocol = "";
            this.cipherSuite = "";
            this.peerCertificatesAcquired = false;
            this.systemTrustManagerExists = false;
            this.systemTrustManagerAcceptedConnection = false;
            this.hostnameVerified = false;
            this.chainValid = false;
            this.chainTrusted = false;
            this.chainTrustedByPubkey = false;
            this.extendedKeyUsageFieldValid = false;
            this.peerCertificates = WireFormatNano.EMPTY_BYTES_ARRAY;
            this.pinTestError = false;
            this.certUserAdded = false;
            this.certInCaStore = false;
            this.trustManagers = TrustManagerInfo.emptyArray();
            this.unknownFieldData = null;
            this.cachedSize = -1;
            return this;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof SslHandshakeInfo)) {
                return false;
            }
            SslHandshakeInfo other = (SslHandshakeInfo) o;
            if (this.sslConnectionMethod != other.sslConnectionMethod) {
                return false;
            }
            if (this.host == null) {
                if (other.host != null) {
                    return false;
                }
            } else if (!this.host.equals(other.host)) {
                return false;
            }
            if (this.socketCreated != other.socketCreated || this.sslConnectionSucceeded != other.sslConnectionSucceeded || this.sessionEstablished != other.sessionEstablished) {
                return false;
            }
            if (this.protocol == null) {
                if (other.protocol != null) {
                    return false;
                }
            } else if (!this.protocol.equals(other.protocol)) {
                return false;
            }
            if (this.cipherSuite == null) {
                if (other.cipherSuite != null) {
                    return false;
                }
            } else if (!this.cipherSuite.equals(other.cipherSuite)) {
                return false;
            }
            if (this.peerCertificatesAcquired != other.peerCertificatesAcquired || this.systemTrustManagerExists != other.systemTrustManagerExists || this.systemTrustManagerAcceptedConnection != other.systemTrustManagerAcceptedConnection || this.hostnameVerified != other.hostnameVerified || this.chainValid != other.chainValid || this.chainTrusted != other.chainTrusted || this.chainTrustedByPubkey != other.chainTrustedByPubkey || this.extendedKeyUsageFieldValid != other.extendedKeyUsageFieldValid || !InternalNano.equals(this.peerCertificates, other.peerCertificates) || this.pinTestError != other.pinTestError || this.certUserAdded != other.certUserAdded || this.certInCaStore != other.certInCaStore || !InternalNano.equals(this.trustManagers, other.trustManagers)) {
                return false;
            }
            if (this.unknownFieldData != null && !this.unknownFieldData.isEmpty()) {
                return this.unknownFieldData.equals(other.unknownFieldData);
            }
            if (other.unknownFieldData == null || other.unknownFieldData.isEmpty()) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int i;
            int i2 = 0;
            int i3 = 1231;
            int hashCode = (((getClass().getName().hashCode() + 527) * 31) + this.sslConnectionMethod) * 31;
            if (this.host == null) {
                i = 0;
            } else {
                i = this.host.hashCode();
            }
            hashCode = (hashCode + i) * 31;
            if (this.socketCreated) {
                i = 1231;
            } else {
                i = 1237;
            }
            hashCode = (hashCode + i) * 31;
            if (this.sslConnectionSucceeded) {
                i = 1231;
            } else {
                i = 1237;
            }
            hashCode = (hashCode + i) * 31;
            if (this.sessionEstablished) {
                i = 1231;
            } else {
                i = 1237;
            }
            hashCode = (hashCode + i) * 31;
            if (this.protocol == null) {
                i = 0;
            } else {
                i = this.protocol.hashCode();
            }
            hashCode = (hashCode + i) * 31;
            if (this.cipherSuite == null) {
                i = 0;
            } else {
                i = this.cipherSuite.hashCode();
            }
            hashCode = (hashCode + i) * 31;
            if (this.peerCertificatesAcquired) {
                i = 1231;
            } else {
                i = 1237;
            }
            hashCode = (hashCode + i) * 31;
            if (this.systemTrustManagerExists) {
                i = 1231;
            } else {
                i = 1237;
            }
            hashCode = (hashCode + i) * 31;
            if (this.systemTrustManagerAcceptedConnection) {
                i = 1231;
            } else {
                i = 1237;
            }
            hashCode = (hashCode + i) * 31;
            if (this.hostnameVerified) {
                i = 1231;
            } else {
                i = 1237;
            }
            hashCode = (hashCode + i) * 31;
            if (this.chainValid) {
                i = 1231;
            } else {
                i = 1237;
            }
            hashCode = (hashCode + i) * 31;
            if (this.chainTrusted) {
                i = 1231;
            } else {
                i = 1237;
            }
            hashCode = (hashCode + i) * 31;
            if (this.chainTrustedByPubkey) {
                i = 1231;
            } else {
                i = 1237;
            }
            hashCode = (hashCode + i) * 31;
            if (this.extendedKeyUsageFieldValid) {
                i = 1231;
            } else {
                i = 1237;
            }
            hashCode = (((hashCode + i) * 31) + InternalNano.hashCode(this.peerCertificates)) * 31;
            if (this.pinTestError) {
                i = 1231;
            } else {
                i = 1237;
            }
            hashCode = (hashCode + i) * 31;
            if (this.certUserAdded) {
                i = 1231;
            } else {
                i = 1237;
            }
            i = (hashCode + i) * 31;
            if (!this.certInCaStore) {
                i3 = 1237;
            }
            i = (((i + i3) * 31) + InternalNano.hashCode(this.trustManagers)) * 31;
            if (!(this.unknownFieldData == null || this.unknownFieldData.isEmpty())) {
                i2 = this.unknownFieldData.hashCode();
            }
            return i + i2;
        }

        public void writeTo(CodedOutputByteBufferNano output) throws IOException {
            if (!(this.host == null || this.host.equals(""))) {
                output.writeString(1, this.host);
            }
            if (this.socketCreated) {
                output.writeBool(2, this.socketCreated);
            }
            if (this.sessionEstablished) {
                output.writeBool(3, this.sessionEstablished);
            }
            if (!(this.protocol == null || this.protocol.equals(""))) {
                output.writeString(4, this.protocol);
            }
            if (!(this.cipherSuite == null || this.cipherSuite.equals(""))) {
                output.writeString(5, this.cipherSuite);
            }
            if (this.peerCertificatesAcquired) {
                output.writeBool(6, this.peerCertificatesAcquired);
            }
            if (this.systemTrustManagerExists) {
                output.writeBool(7, this.systemTrustManagerExists);
            }
            if (this.systemTrustManagerAcceptedConnection) {
                output.writeBool(8, this.systemTrustManagerAcceptedConnection);
            }
            if (this.hostnameVerified) {
                output.writeBool(9, this.hostnameVerified);
            }
            if (this.chainValid) {
                output.writeBool(10, this.chainValid);
            }
            if (this.chainTrusted) {
                output.writeBool(11, this.chainTrusted);
            }
            if (this.extendedKeyUsageFieldValid) {
                output.writeBool(12, this.extendedKeyUsageFieldValid);
            }
            if (this.peerCertificates != null && this.peerCertificates.length > 0) {
                for (byte[] element : this.peerCertificates) {
                    if (element != null) {
                        output.writeBytes(13, element);
                    }
                }
            }
            if (this.pinTestError) {
                output.writeBool(14, this.pinTestError);
            }
            if (this.certUserAdded) {
                output.writeBool(15, this.certUserAdded);
            }
            if (this.certInCaStore) {
                output.writeBool(16, this.certInCaStore);
            }
            if (this.trustManagers != null && this.trustManagers.length > 0) {
                for (TrustManagerInfo element2 : this.trustManagers) {
                    if (element2 != null) {
                        output.writeMessage(17, element2);
                    }
                }
            }
            if (this.chainTrustedByPubkey) {
                output.writeBool(18, this.chainTrustedByPubkey);
            }
            if (this.sslConnectionMethod != 0) {
                output.writeInt32(19, this.sslConnectionMethod);
            }
            if (this.sslConnectionSucceeded) {
                output.writeBool(20, this.sslConnectionSucceeded);
            }
            super.writeTo(output);
        }

        protected int computeSerializedSize() {
            int size = super.computeSerializedSize();
            if (!(this.host == null || this.host.equals(""))) {
                size += CodedOutputByteBufferNano.computeStringSize(1, this.host);
            }
            if (this.socketCreated) {
                size += CodedOutputByteBufferNano.computeBoolSize(2, this.socketCreated);
            }
            if (this.sessionEstablished) {
                size += CodedOutputByteBufferNano.computeBoolSize(3, this.sessionEstablished);
            }
            if (!(this.protocol == null || this.protocol.equals(""))) {
                size += CodedOutputByteBufferNano.computeStringSize(4, this.protocol);
            }
            if (!(this.cipherSuite == null || this.cipherSuite.equals(""))) {
                size += CodedOutputByteBufferNano.computeStringSize(5, this.cipherSuite);
            }
            if (this.peerCertificatesAcquired) {
                size += CodedOutputByteBufferNano.computeBoolSize(6, this.peerCertificatesAcquired);
            }
            if (this.systemTrustManagerExists) {
                size += CodedOutputByteBufferNano.computeBoolSize(7, this.systemTrustManagerExists);
            }
            if (this.systemTrustManagerAcceptedConnection) {
                size += CodedOutputByteBufferNano.computeBoolSize(8, this.systemTrustManagerAcceptedConnection);
            }
            if (this.hostnameVerified) {
                size += CodedOutputByteBufferNano.computeBoolSize(9, this.hostnameVerified);
            }
            if (this.chainValid) {
                size += CodedOutputByteBufferNano.computeBoolSize(10, this.chainValid);
            }
            if (this.chainTrusted) {
                size += CodedOutputByteBufferNano.computeBoolSize(11, this.chainTrusted);
            }
            if (this.extendedKeyUsageFieldValid) {
                size += CodedOutputByteBufferNano.computeBoolSize(12, this.extendedKeyUsageFieldValid);
            }
            if (this.peerCertificates != null && this.peerCertificates.length > 0) {
                int dataCount = 0;
                int dataSize = 0;
                for (byte[] element : this.peerCertificates) {
                    if (element != null) {
                        dataCount++;
                        dataSize += CodedOutputByteBufferNano.computeBytesSizeNoTag(element);
                    }
                }
                size = (size + dataSize) + (dataCount * 1);
            }
            if (this.pinTestError) {
                size += CodedOutputByteBufferNano.computeBoolSize(14, this.pinTestError);
            }
            if (this.certUserAdded) {
                size += CodedOutputByteBufferNano.computeBoolSize(15, this.certUserAdded);
            }
            if (this.certInCaStore) {
                size += CodedOutputByteBufferNano.computeBoolSize(16, this.certInCaStore);
            }
            if (this.trustManagers != null && this.trustManagers.length > 0) {
                for (TrustManagerInfo element2 : this.trustManagers) {
                    if (element2 != null) {
                        size += CodedOutputByteBufferNano.computeMessageSize(17, element2);
                    }
                }
            }
            if (this.chainTrustedByPubkey) {
                size += CodedOutputByteBufferNano.computeBoolSize(18, this.chainTrustedByPubkey);
            }
            if (this.sslConnectionMethod != 0) {
                size += CodedOutputByteBufferNano.computeInt32Size(19, this.sslConnectionMethod);
            }
            if (this.sslConnectionSucceeded) {
                return size + CodedOutputByteBufferNano.computeBoolSize(20, this.sslConnectionSucceeded);
            }
            return size;
        }

        public SslHandshakeInfo mergeFrom(CodedInputByteBufferNano input) throws IOException {
            while (true) {
                int tag = input.readTag();
                int arrayLength;
                int i;
                switch (tag) {
                    case 0:
                        break;
                    case 10:
                        this.host = input.readString();
                        continue;
                    case 16:
                        this.socketCreated = input.readBool();
                        continue;
                    case 24:
                        this.sessionEstablished = input.readBool();
                        continue;
                    case 34:
                        this.protocol = input.readString();
                        continue;
                    case MotionEventCompat.AXIS_GENERIC_11 /*42*/:
                        this.cipherSuite = input.readString();
                        continue;
                    case 48:
                        this.peerCertificatesAcquired = input.readBool();
                        continue;
                    case 56:
                        this.systemTrustManagerExists = input.readBool();
                        continue;
                    case 64:
                        this.systemTrustManagerAcceptedConnection = input.readBool();
                        continue;
                    case 72:
                        this.hostnameVerified = input.readBool();
                        continue;
                    case 80:
                        this.chainValid = input.readBool();
                        continue;
                    case 88:
                        this.chainTrusted = input.readBool();
                        continue;
                    case 96:
                        this.extendedKeyUsageFieldValid = input.readBool();
                        continue;
                    case 106:
                        arrayLength = WireFormatNano.getRepeatedFieldArrayLength(input, 106);
                        i = this.peerCertificates == null ? 0 : this.peerCertificates.length;
                        byte[][] newArray = new byte[(i + arrayLength)][];
                        if (i != 0) {
                            System.arraycopy(this.peerCertificates, 0, newArray, 0, i);
                        }
                        while (i < newArray.length - 1) {
                            newArray[i] = input.readBytes();
                            input.readTag();
                            i++;
                        }
                        newArray[i] = input.readBytes();
                        this.peerCertificates = newArray;
                        continue;
                    case 112:
                        this.pinTestError = input.readBool();
                        continue;
                    case 120:
                        this.certUserAdded = input.readBool();
                        continue;
                    case 128:
                        this.certInCaStore = input.readBool();
                        continue;
                    case 138:
                        arrayLength = WireFormatNano.getRepeatedFieldArrayLength(input, 138);
                        if (this.trustManagers == null) {
                            i = 0;
                        } else {
                            i = this.trustManagers.length;
                        }
                        TrustManagerInfo[] newArray2 = new TrustManagerInfo[(i + arrayLength)];
                        if (i != 0) {
                            System.arraycopy(this.trustManagers, 0, newArray2, 0, i);
                        }
                        while (i < newArray2.length - 1) {
                            newArray2[i] = new TrustManagerInfo();
                            input.readMessage(newArray2[i]);
                            input.readTag();
                            i++;
                        }
                        newArray2[i] = new TrustManagerInfo();
                        input.readMessage(newArray2[i]);
                        this.trustManagers = newArray2;
                        continue;
                    case 144:
                        this.chainTrustedByPubkey = input.readBool();
                        continue;
                    case 152:
                        int value = input.readInt32();
                        switch (value) {
                            case 0:
                            case 1:
                            case 2:
                                this.sslConnectionMethod = value;
                                break;
                            default:
                                continue;
                        }
                    case 160:
                        this.sslConnectionSucceeded = input.readBool();
                        continue;
                    default:
                        if (!super.storeUnknownField(input, tag)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public static SslHandshakeInfo parseFrom(byte[] data) throws InvalidProtocolBufferNanoException {
            return (SslHandshakeInfo) MessageNano.mergeFrom(new SslHandshakeInfo(), data);
        }

        public static SslHandshakeInfo parseFrom(CodedInputByteBufferNano input) throws IOException {
            return new SslHandshakeInfo().mergeFrom(input);
        }
    }

    public static final class SslRedirectInfo extends ExtendableMessageNano<SslRedirectInfo> {
        public static final int ANDROID_HTTP_CLIENT = 2;
        public static final int CHROME_LINUX_USER_AGENT = 0;
        public static final int HTTP_URL_CONNECTION = 1;
        public static final int SAFARI_IPHONE_USER_AGENT = 1;
        private static volatile SslRedirectInfo[] _emptyArray;
        public boolean endPointConnected;
        public String endPointUrl;
        public String host;
        public int httpClientUsed;
        public String[] ipAddressesForEndPointUrl;
        public String redirectHeaderValue;
        public int responseCode;
        public int userAgentUsed;

        public static SslRedirectInfo[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new SslRedirectInfo[0];
                    }
                }
            }
            return _emptyArray;
        }

        public SslRedirectInfo() {
            clear();
        }

        public SslRedirectInfo clear() {
            this.host = "";
            this.httpClientUsed = 1;
            this.responseCode = 0;
            this.redirectHeaderValue = "";
            this.endPointUrl = "";
            this.ipAddressesForEndPointUrl = WireFormatNano.EMPTY_STRING_ARRAY;
            this.userAgentUsed = 0;
            this.endPointConnected = false;
            this.unknownFieldData = null;
            this.cachedSize = -1;
            return this;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof SslRedirectInfo)) {
                return false;
            }
            SslRedirectInfo other = (SslRedirectInfo) o;
            if (this.host == null) {
                if (other.host != null) {
                    return false;
                }
            } else if (!this.host.equals(other.host)) {
                return false;
            }
            if (this.httpClientUsed != other.httpClientUsed || this.responseCode != other.responseCode) {
                return false;
            }
            if (this.redirectHeaderValue == null) {
                if (other.redirectHeaderValue != null) {
                    return false;
                }
            } else if (!this.redirectHeaderValue.equals(other.redirectHeaderValue)) {
                return false;
            }
            if (this.endPointUrl == null) {
                if (other.endPointUrl != null) {
                    return false;
                }
            } else if (!this.endPointUrl.equals(other.endPointUrl)) {
                return false;
            }
            if (!InternalNano.equals(this.ipAddressesForEndPointUrl, other.ipAddressesForEndPointUrl) || this.userAgentUsed != other.userAgentUsed || this.endPointConnected != other.endPointConnected) {
                return false;
            }
            if (this.unknownFieldData != null && !this.unknownFieldData.isEmpty()) {
                return this.unknownFieldData.equals(other.unknownFieldData);
            }
            if (other.unknownFieldData == null || other.unknownFieldData.isEmpty()) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int i;
            int i2 = 0;
            int hashCode = (getClass().getName().hashCode() + 527) * 31;
            if (this.host == null) {
                i = 0;
            } else {
                i = this.host.hashCode();
            }
            hashCode = (((((hashCode + i) * 31) + this.httpClientUsed) * 31) + this.responseCode) * 31;
            if (this.redirectHeaderValue == null) {
                i = 0;
            } else {
                i = this.redirectHeaderValue.hashCode();
            }
            hashCode = (hashCode + i) * 31;
            if (this.endPointUrl == null) {
                i = 0;
            } else {
                i = this.endPointUrl.hashCode();
            }
            i = (((((((hashCode + i) * 31) + InternalNano.hashCode(this.ipAddressesForEndPointUrl)) * 31) + this.userAgentUsed) * 31) + (this.endPointConnected ? 1231 : 1237)) * 31;
            if (!(this.unknownFieldData == null || this.unknownFieldData.isEmpty())) {
                i2 = this.unknownFieldData.hashCode();
            }
            return i + i2;
        }

        public void writeTo(CodedOutputByteBufferNano output) throws IOException {
            if (!(this.host == null || this.host.equals(""))) {
                output.writeString(1, this.host);
            }
            if (this.httpClientUsed != 1) {
                output.writeInt32(2, this.httpClientUsed);
            }
            if (this.responseCode != 0) {
                output.writeInt32(3, this.responseCode);
            }
            if (!(this.redirectHeaderValue == null || this.redirectHeaderValue.equals(""))) {
                output.writeString(4, this.redirectHeaderValue);
            }
            if (!(this.endPointUrl == null || this.endPointUrl.equals(""))) {
                output.writeString(5, this.endPointUrl);
            }
            if (this.ipAddressesForEndPointUrl != null && this.ipAddressesForEndPointUrl.length > 0) {
                for (String element : this.ipAddressesForEndPointUrl) {
                    if (element != null) {
                        output.writeString(6, element);
                    }
                }
            }
            if (this.userAgentUsed != 0) {
                output.writeInt32(7, this.userAgentUsed);
            }
            if (this.endPointConnected) {
                output.writeBool(8, this.endPointConnected);
            }
            super.writeTo(output);
        }

        protected int computeSerializedSize() {
            int size = super.computeSerializedSize();
            if (!(this.host == null || this.host.equals(""))) {
                size += CodedOutputByteBufferNano.computeStringSize(1, this.host);
            }
            if (this.httpClientUsed != 1) {
                size += CodedOutputByteBufferNano.computeInt32Size(2, this.httpClientUsed);
            }
            if (this.responseCode != 0) {
                size += CodedOutputByteBufferNano.computeInt32Size(3, this.responseCode);
            }
            if (!(this.redirectHeaderValue == null || this.redirectHeaderValue.equals(""))) {
                size += CodedOutputByteBufferNano.computeStringSize(4, this.redirectHeaderValue);
            }
            if (!(this.endPointUrl == null || this.endPointUrl.equals(""))) {
                size += CodedOutputByteBufferNano.computeStringSize(5, this.endPointUrl);
            }
            if (this.ipAddressesForEndPointUrl != null && this.ipAddressesForEndPointUrl.length > 0) {
                int dataCount = 0;
                int dataSize = 0;
                for (String element : this.ipAddressesForEndPointUrl) {
                    if (element != null) {
                        dataCount++;
                        dataSize += CodedOutputByteBufferNano.computeStringSizeNoTag(element);
                    }
                }
                size = (size + dataSize) + (dataCount * 1);
            }
            if (this.userAgentUsed != 0) {
                size += CodedOutputByteBufferNano.computeInt32Size(7, this.userAgentUsed);
            }
            if (this.endPointConnected) {
                return size + CodedOutputByteBufferNano.computeBoolSize(8, this.endPointConnected);
            }
            return size;
        }

        public SslRedirectInfo mergeFrom(CodedInputByteBufferNano input) throws IOException {
            while (true) {
                int tag = input.readTag();
                int value;
                switch (tag) {
                    case 0:
                        break;
                    case 10:
                        this.host = input.readString();
                        continue;
                    case 16:
                        value = input.readInt32();
                        switch (value) {
                            case 1:
                            case 2:
                                this.httpClientUsed = value;
                                break;
                            default:
                                continue;
                        }
                    case 24:
                        this.responseCode = input.readInt32();
                        continue;
                    case 34:
                        this.redirectHeaderValue = input.readString();
                        continue;
                    case MotionEventCompat.AXIS_GENERIC_11 /*42*/:
                        this.endPointUrl = input.readString();
                        continue;
                    case 50:
                        int arrayLength = WireFormatNano.getRepeatedFieldArrayLength(input, 50);
                        int i = this.ipAddressesForEndPointUrl == null ? 0 : this.ipAddressesForEndPointUrl.length;
                        String[] newArray = new String[(i + arrayLength)];
                        if (i != 0) {
                            System.arraycopy(this.ipAddressesForEndPointUrl, 0, newArray, 0, i);
                        }
                        while (i < newArray.length - 1) {
                            newArray[i] = input.readString();
                            input.readTag();
                            i++;
                        }
                        newArray[i] = input.readString();
                        this.ipAddressesForEndPointUrl = newArray;
                        continue;
                    case 56:
                        value = input.readInt32();
                        switch (value) {
                            case 0:
                            case 1:
                                this.userAgentUsed = value;
                                break;
                            default:
                                continue;
                        }
                    case 64:
                        this.endPointConnected = input.readBool();
                        continue;
                    default:
                        if (!super.storeUnknownField(input, tag)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public static SslRedirectInfo parseFrom(byte[] data) throws InvalidProtocolBufferNanoException {
            return (SslRedirectInfo) MessageNano.mergeFrom(new SslRedirectInfo(), data);
        }

        public static SslRedirectInfo parseFrom(CodedInputByteBufferNano input) throws IOException {
            return new SslRedirectInfo().mergeFrom(input);
        }
    }

    public static final class SystemPartitionFileInfoNormal extends ExtendableMessageNano<SystemPartitionFileInfoNormal> {
        private static volatile SystemPartitionFileInfoNormal[] _emptyArray;
        public boolean couldNotCheck;
        public FileInfo[] fileInfo;

        public static final class FileInfo extends ExtendableMessageNano<FileInfo> {
            private static volatile FileInfo[] _emptyArray;
            public String path;
            public byte[] sha256;
            public boolean symlink;
            public String symlinkTarget;

            public static FileInfo[] emptyArray() {
                if (_emptyArray == null) {
                    synchronized (InternalNano.LAZY_INIT_LOCK) {
                        if (_emptyArray == null) {
                            _emptyArray = new FileInfo[0];
                        }
                    }
                }
                return _emptyArray;
            }

            public FileInfo() {
                clear();
            }

            public FileInfo clear() {
                this.path = "";
                this.sha256 = WireFormatNano.EMPTY_BYTES;
                this.symlink = false;
                this.symlinkTarget = "";
                this.unknownFieldData = null;
                this.cachedSize = -1;
                return this;
            }

            public boolean equals(Object o) {
                if (o == this) {
                    return true;
                }
                if (!(o instanceof FileInfo)) {
                    return false;
                }
                FileInfo other = (FileInfo) o;
                if (this.path == null) {
                    if (other.path != null) {
                        return false;
                    }
                } else if (!this.path.equals(other.path)) {
                    return false;
                }
                if (!Arrays.equals(this.sha256, other.sha256) || this.symlink != other.symlink) {
                    return false;
                }
                if (this.symlinkTarget == null) {
                    if (other.symlinkTarget != null) {
                        return false;
                    }
                } else if (!this.symlinkTarget.equals(other.symlinkTarget)) {
                    return false;
                }
                if (this.unknownFieldData != null && !this.unknownFieldData.isEmpty()) {
                    return this.unknownFieldData.equals(other.unknownFieldData);
                }
                if (other.unknownFieldData == null || other.unknownFieldData.isEmpty()) {
                    return true;
                }
                return false;
            }

            public int hashCode() {
                int i;
                int i2 = 0;
                int hashCode = (getClass().getName().hashCode() + 527) * 31;
                if (this.path == null) {
                    i = 0;
                } else {
                    i = this.path.hashCode();
                }
                hashCode = (((((hashCode + i) * 31) + Arrays.hashCode(this.sha256)) * 31) + (this.symlink ? 1231 : 1237)) * 31;
                if (this.symlinkTarget == null) {
                    i = 0;
                } else {
                    i = this.symlinkTarget.hashCode();
                }
                i = (hashCode + i) * 31;
                if (!(this.unknownFieldData == null || this.unknownFieldData.isEmpty())) {
                    i2 = this.unknownFieldData.hashCode();
                }
                return i + i2;
            }

            public void writeTo(CodedOutputByteBufferNano output) throws IOException {
                if (!(this.path == null || this.path.equals(""))) {
                    output.writeString(1, this.path);
                }
                if (!Arrays.equals(this.sha256, WireFormatNano.EMPTY_BYTES)) {
                    output.writeBytes(2, this.sha256);
                }
                if (this.symlink) {
                    output.writeBool(3, this.symlink);
                }
                if (!(this.symlinkTarget == null || this.symlinkTarget.equals(""))) {
                    output.writeString(4, this.symlinkTarget);
                }
                super.writeTo(output);
            }

            protected int computeSerializedSize() {
                int size = super.computeSerializedSize();
                if (!(this.path == null || this.path.equals(""))) {
                    size += CodedOutputByteBufferNano.computeStringSize(1, this.path);
                }
                if (!Arrays.equals(this.sha256, WireFormatNano.EMPTY_BYTES)) {
                    size += CodedOutputByteBufferNano.computeBytesSize(2, this.sha256);
                }
                if (this.symlink) {
                    size += CodedOutputByteBufferNano.computeBoolSize(3, this.symlink);
                }
                if (this.symlinkTarget == null || this.symlinkTarget.equals("")) {
                    return size;
                }
                return size + CodedOutputByteBufferNano.computeStringSize(4, this.symlinkTarget);
            }

            public FileInfo mergeFrom(CodedInputByteBufferNano input) throws IOException {
                while (true) {
                    int tag = input.readTag();
                    switch (tag) {
                        case 0:
                            break;
                        case 10:
                            this.path = input.readString();
                            continue;
                        case 18:
                            this.sha256 = input.readBytes();
                            continue;
                        case 24:
                            this.symlink = input.readBool();
                            continue;
                        case 34:
                            this.symlinkTarget = input.readString();
                            continue;
                        default:
                            if (!super.storeUnknownField(input, tag)) {
                                break;
                            }
                            continue;
                    }
                    return this;
                }
            }

            public static FileInfo parseFrom(byte[] data) throws InvalidProtocolBufferNanoException {
                return (FileInfo) MessageNano.mergeFrom(new FileInfo(), data);
            }

            public static FileInfo parseFrom(CodedInputByteBufferNano input) throws IOException {
                return new FileInfo().mergeFrom(input);
            }
        }

        public static SystemPartitionFileInfoNormal[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new SystemPartitionFileInfoNormal[0];
                    }
                }
            }
            return _emptyArray;
        }

        public SystemPartitionFileInfoNormal() {
            clear();
        }

        public SystemPartitionFileInfoNormal clear() {
            this.couldNotCheck = false;
            this.fileInfo = FileInfo.emptyArray();
            this.unknownFieldData = null;
            this.cachedSize = -1;
            return this;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof SystemPartitionFileInfoNormal)) {
                return false;
            }
            SystemPartitionFileInfoNormal other = (SystemPartitionFileInfoNormal) o;
            if (this.couldNotCheck != other.couldNotCheck || !InternalNano.equals(this.fileInfo, other.fileInfo)) {
                return false;
            }
            if (this.unknownFieldData != null && !this.unknownFieldData.isEmpty()) {
                return this.unknownFieldData.equals(other.unknownFieldData);
            }
            if (other.unknownFieldData == null || other.unknownFieldData.isEmpty()) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int i;
            int hashCode = (((((getClass().getName().hashCode() + 527) * 31) + (this.couldNotCheck ? 1231 : 1237)) * 31) + InternalNano.hashCode(this.fileInfo)) * 31;
            if (this.unknownFieldData == null || this.unknownFieldData.isEmpty()) {
                i = 0;
            } else {
                i = this.unknownFieldData.hashCode();
            }
            return hashCode + i;
        }

        public void writeTo(CodedOutputByteBufferNano output) throws IOException {
            if (this.couldNotCheck) {
                output.writeBool(1, this.couldNotCheck);
            }
            if (this.fileInfo != null && this.fileInfo.length > 0) {
                for (FileInfo element : this.fileInfo) {
                    if (element != null) {
                        output.writeMessage(2, element);
                    }
                }
            }
            super.writeTo(output);
        }

        protected int computeSerializedSize() {
            int size = super.computeSerializedSize();
            if (this.couldNotCheck) {
                size += CodedOutputByteBufferNano.computeBoolSize(1, this.couldNotCheck);
            }
            if (this.fileInfo != null && this.fileInfo.length > 0) {
                for (FileInfo element : this.fileInfo) {
                    if (element != null) {
                        size += CodedOutputByteBufferNano.computeMessageSize(2, element);
                    }
                }
            }
            return size;
        }

        public SystemPartitionFileInfoNormal mergeFrom(CodedInputByteBufferNano input) throws IOException {
            while (true) {
                int tag = input.readTag();
                switch (tag) {
                    case 0:
                        break;
                    case 8:
                        this.couldNotCheck = input.readBool();
                        continue;
                    case 18:
                        int i;
                        int arrayLength = WireFormatNano.getRepeatedFieldArrayLength(input, 18);
                        if (this.fileInfo == null) {
                            i = 0;
                        } else {
                            i = this.fileInfo.length;
                        }
                        FileInfo[] newArray = new FileInfo[(i + arrayLength)];
                        if (i != 0) {
                            System.arraycopy(this.fileInfo, 0, newArray, 0, i);
                        }
                        while (i < newArray.length - 1) {
                            newArray[i] = new FileInfo();
                            input.readMessage(newArray[i]);
                            input.readTag();
                            i++;
                        }
                        newArray[i] = new FileInfo();
                        input.readMessage(newArray[i]);
                        this.fileInfo = newArray;
                        continue;
                    default:
                        if (!super.storeUnknownField(input, tag)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public static SystemPartitionFileInfoNormal parseFrom(byte[] data) throws InvalidProtocolBufferNanoException {
            return (SystemPartitionFileInfoNormal) MessageNano.mergeFrom(new SystemPartitionFileInfoNormal(), data);
        }

        public static SystemPartitionFileInfoNormal parseFrom(CodedInputByteBufferNano input) throws IOException {
            return new SystemPartitionFileInfoNormal().mergeFrom(input);
        }
    }

    public static final class SystemPropertyNormal extends ExtendableMessageNano<SystemPropertyNormal> {
        private static volatile SystemPropertyNormal[] _emptyArray;
        public String name;
        public String value;

        public static SystemPropertyNormal[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new SystemPropertyNormal[0];
                    }
                }
            }
            return _emptyArray;
        }

        public SystemPropertyNormal() {
            clear();
        }

        public SystemPropertyNormal clear() {
            this.name = "";
            this.value = "";
            this.unknownFieldData = null;
            this.cachedSize = -1;
            return this;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof SystemPropertyNormal)) {
                return false;
            }
            SystemPropertyNormal other = (SystemPropertyNormal) o;
            if (this.name == null) {
                if (other.name != null) {
                    return false;
                }
            } else if (!this.name.equals(other.name)) {
                return false;
            }
            if (this.value == null) {
                if (other.value != null) {
                    return false;
                }
            } else if (!this.value.equals(other.value)) {
                return false;
            }
            if (this.unknownFieldData != null && !this.unknownFieldData.isEmpty()) {
                return this.unknownFieldData.equals(other.unknownFieldData);
            }
            if (other.unknownFieldData == null || other.unknownFieldData.isEmpty()) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int i;
            int i2 = 0;
            int hashCode = (getClass().getName().hashCode() + 527) * 31;
            if (this.name == null) {
                i = 0;
            } else {
                i = this.name.hashCode();
            }
            hashCode = (hashCode + i) * 31;
            if (this.value == null) {
                i = 0;
            } else {
                i = this.value.hashCode();
            }
            i = (hashCode + i) * 31;
            if (!(this.unknownFieldData == null || this.unknownFieldData.isEmpty())) {
                i2 = this.unknownFieldData.hashCode();
            }
            return i + i2;
        }

        public void writeTo(CodedOutputByteBufferNano output) throws IOException {
            if (!(this.name == null || this.name.equals(""))) {
                output.writeString(1, this.name);
            }
            if (!(this.value == null || this.value.equals(""))) {
                output.writeString(2, this.value);
            }
            super.writeTo(output);
        }

        protected int computeSerializedSize() {
            int size = super.computeSerializedSize();
            if (!(this.name == null || this.name.equals(""))) {
                size += CodedOutputByteBufferNano.computeStringSize(1, this.name);
            }
            if (this.value == null || this.value.equals("")) {
                return size;
            }
            return size + CodedOutputByteBufferNano.computeStringSize(2, this.value);
        }

        public SystemPropertyNormal mergeFrom(CodedInputByteBufferNano input) throws IOException {
            while (true) {
                int tag = input.readTag();
                switch (tag) {
                    case 0:
                        break;
                    case 10:
                        this.name = input.readString();
                        continue;
                    case 18:
                        this.value = input.readString();
                        continue;
                    default:
                        if (!super.storeUnknownField(input, tag)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public static SystemPropertyNormal parseFrom(byte[] data) throws InvalidProtocolBufferNanoException {
            return (SystemPropertyNormal) MessageNano.mergeFrom(new SystemPropertyNormal(), data);
        }

        public static SystemPropertyNormal parseFrom(CodedInputByteBufferNano input) throws IOException {
            return new SystemPropertyNormal().mergeFrom(input);
        }
    }

    public static final class TrustManagerInfo extends ExtendableMessageNano<TrustManagerInfo> {
        private static volatile TrustManagerInfo[] _emptyArray;
        public boolean acceptedConnection;

        public static TrustManagerInfo[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new TrustManagerInfo[0];
                    }
                }
            }
            return _emptyArray;
        }

        public TrustManagerInfo() {
            clear();
        }

        public TrustManagerInfo clear() {
            this.acceptedConnection = false;
            this.unknownFieldData = null;
            this.cachedSize = -1;
            return this;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof TrustManagerInfo)) {
                return false;
            }
            TrustManagerInfo other = (TrustManagerInfo) o;
            if (this.acceptedConnection != other.acceptedConnection) {
                return false;
            }
            if (this.unknownFieldData != null && !this.unknownFieldData.isEmpty()) {
                return this.unknownFieldData.equals(other.unknownFieldData);
            }
            if (other.unknownFieldData == null || other.unknownFieldData.isEmpty()) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            int i;
            int hashCode = (((getClass().getName().hashCode() + 527) * 31) + (this.acceptedConnection ? 1231 : 1237)) * 31;
            if (this.unknownFieldData == null || this.unknownFieldData.isEmpty()) {
                i = 0;
            } else {
                i = this.unknownFieldData.hashCode();
            }
            return hashCode + i;
        }

        public void writeTo(CodedOutputByteBufferNano output) throws IOException {
            if (this.acceptedConnection) {
                output.writeBool(1, this.acceptedConnection);
            }
            super.writeTo(output);
        }

        protected int computeSerializedSize() {
            int size = super.computeSerializedSize();
            if (this.acceptedConnection) {
                return size + CodedOutputByteBufferNano.computeBoolSize(1, this.acceptedConnection);
            }
            return size;
        }

        public TrustManagerInfo mergeFrom(CodedInputByteBufferNano input) throws IOException {
            while (true) {
                int tag = input.readTag();
                switch (tag) {
                    case 0:
                        break;
                    case 8:
                        this.acceptedConnection = input.readBool();
                        continue;
                    default:
                        if (!super.storeUnknownField(input, tag)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public static TrustManagerInfo parseFrom(byte[] data) throws InvalidProtocolBufferNanoException {
            return (TrustManagerInfo) MessageNano.mergeFrom(new TrustManagerInfo(), data);
        }

        public static TrustManagerInfo parseFrom(CodedInputByteBufferNano input) throws IOException {
            return new TrustManagerInfo().mergeFrom(input);
        }
    }
}
