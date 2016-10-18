package com.google.android.snet.nano;

import android.support.v4.media.TransportMediator;
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

public interface IdleLogs {
    public static final int BAD_HASH = 2;
    public static final int GOOD_HASH = 1;
    public static final int HASH_MATCH_UNSPECIFIED = 0;
    public static final int UNKNOWN_HASH = 3;

    public static final class AppInfo extends ExtendableMessageNano<AppInfo> {
        private static volatile AppInfo[] _emptyArray;
        public String apkSha256;
        public byte[] apkSha256Bytes;
        public int apkVersionCode;
        public String packageName;
        public String[] signatureSha256;
        public byte[][] signatureSha256Bytes;
        public boolean systemApp;

        public static AppInfo[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new AppInfo[0];
                    }
                }
            }
            return _emptyArray;
        }

        public AppInfo() {
            clear();
        }

        public AppInfo clear() {
            this.packageName = "";
            this.apkSha256 = "";
            this.signatureSha256 = WireFormatNano.EMPTY_STRING_ARRAY;
            this.systemApp = false;
            this.apkSha256Bytes = WireFormatNano.EMPTY_BYTES;
            this.signatureSha256Bytes = WireFormatNano.EMPTY_BYTES_ARRAY;
            this.apkVersionCode = 0;
            this.unknownFieldData = null;
            this.cachedSize = -1;
            return this;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof AppInfo)) {
                return false;
            }
            AppInfo other = (AppInfo) o;
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
            if (!InternalNano.equals(this.signatureSha256, other.signatureSha256) || this.systemApp != other.systemApp || !Arrays.equals(this.apkSha256Bytes, other.apkSha256Bytes) || !InternalNano.equals(this.signatureSha256Bytes, other.signatureSha256Bytes) || this.apkVersionCode != other.apkVersionCode) {
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
            i = (((((((((((hashCode + i) * 31) + InternalNano.hashCode(this.signatureSha256)) * 31) + (this.systemApp ? 1231 : 1237)) * 31) + Arrays.hashCode(this.apkSha256Bytes)) * 31) + InternalNano.hashCode(this.signatureSha256Bytes)) * 31) + this.apkVersionCode) * 31;
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
            if (this.apkVersionCode != 0) {
                output.writeInt32(7, this.apkVersionCode);
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
            if (this.signatureSha256Bytes != null && this.signatureSha256Bytes.length > 0) {
                dataCount = 0;
                dataSize = 0;
                for (byte[] element2 : this.signatureSha256Bytes) {
                    if (element2 != null) {
                        dataCount++;
                        dataSize += CodedOutputByteBufferNano.computeBytesSizeNoTag(element2);
                    }
                }
                size = (size + dataSize) + (dataCount * 1);
            }
            if (this.apkVersionCode != 0) {
                return size + CodedOutputByteBufferNano.computeInt32Size(7, this.apkVersionCode);
            }
            return size;
        }

        public AppInfo mergeFrom(CodedInputByteBufferNano input) throws IOException {
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
                    case 56:
                        this.apkVersionCode = input.readInt32();
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

        public static AppInfo parseFrom(byte[] data) throws InvalidProtocolBufferNanoException {
            return (AppInfo) MessageNano.mergeFrom(new AppInfo(), data);
        }

        public static AppInfo parseFrom(CodedInputByteBufferNano input) throws IOException {
            return new AppInfo().mergeFrom(input);
        }
    }

    public static final class DMVerityCorrection extends ExtendableMessageNano<DMVerityCorrection> {
        private static volatile DMVerityCorrection[] _emptyArray;
        public int errorCorrection;
        public String partitionName;

        public static DMVerityCorrection[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new DMVerityCorrection[0];
                    }
                }
            }
            return _emptyArray;
        }

        public DMVerityCorrection() {
            clear();
        }

        public DMVerityCorrection clear() {
            this.partitionName = "";
            this.errorCorrection = 0;
            this.unknownFieldData = null;
            this.cachedSize = -1;
            return this;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof DMVerityCorrection)) {
                return false;
            }
            DMVerityCorrection other = (DMVerityCorrection) o;
            if (this.partitionName == null) {
                if (other.partitionName != null) {
                    return false;
                }
            } else if (!this.partitionName.equals(other.partitionName)) {
                return false;
            }
            if (this.errorCorrection != other.errorCorrection) {
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
            if (this.partitionName == null) {
                i = 0;
            } else {
                i = this.partitionName.hashCode();
            }
            i = (((hashCode + i) * 31) + this.errorCorrection) * 31;
            if (!(this.unknownFieldData == null || this.unknownFieldData.isEmpty())) {
                i2 = this.unknownFieldData.hashCode();
            }
            return i + i2;
        }

        public void writeTo(CodedOutputByteBufferNano output) throws IOException {
            if (!(this.partitionName == null || this.partitionName.equals(""))) {
                output.writeString(1, this.partitionName);
            }
            if (this.errorCorrection != 0) {
                output.writeInt32(2, this.errorCorrection);
            }
            super.writeTo(output);
        }

        protected int computeSerializedSize() {
            int size = super.computeSerializedSize();
            if (!(this.partitionName == null || this.partitionName.equals(""))) {
                size += CodedOutputByteBufferNano.computeStringSize(1, this.partitionName);
            }
            if (this.errorCorrection != 0) {
                return size + CodedOutputByteBufferNano.computeInt32Size(2, this.errorCorrection);
            }
            return size;
        }

        public DMVerityCorrection mergeFrom(CodedInputByteBufferNano input) throws IOException {
            while (true) {
                int tag = input.readTag();
                switch (tag) {
                    case 0:
                        break;
                    case 10:
                        this.partitionName = input.readString();
                        continue;
                    case 16:
                        this.errorCorrection = input.readInt32();
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

        public static DMVerityCorrection parseFrom(byte[] data) throws InvalidProtocolBufferNanoException {
            return (DMVerityCorrection) MessageNano.mergeFrom(new DMVerityCorrection(), data);
        }

        public static DMVerityCorrection parseFrom(CodedInputByteBufferNano input) throws IOException {
            return new DMVerityCorrection().mergeFrom(input);
        }
    }

    public static final class DalvikCacheInfo extends ExtendableMessageNano<DalvikCacheInfo> {
        private static volatile DalvikCacheInfo[] _emptyArray;
        public FileInfo[] changedFiles;

        public static final class FileInfo extends ExtendableMessageNano<FileInfo> {
            private static volatile FileInfo[] _emptyArray;
            public String filename;
            public byte[] sha256;
            public long timeSec;

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
                this.filename = "";
                this.sha256 = WireFormatNano.EMPTY_BYTES;
                this.timeSec = 0;
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
                if (this.filename == null) {
                    if (other.filename != null) {
                        return false;
                    }
                } else if (!this.filename.equals(other.filename)) {
                    return false;
                }
                if (!Arrays.equals(this.sha256, other.sha256) || this.timeSec != other.timeSec) {
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
                if (this.filename == null) {
                    i = 0;
                } else {
                    i = this.filename.hashCode();
                }
                i = (((((hashCode + i) * 31) + Arrays.hashCode(this.sha256)) * 31) + ((int) (this.timeSec ^ (this.timeSec >>> 32)))) * 31;
                if (!(this.unknownFieldData == null || this.unknownFieldData.isEmpty())) {
                    i2 = this.unknownFieldData.hashCode();
                }
                return i + i2;
            }

            public void writeTo(CodedOutputByteBufferNano output) throws IOException {
                if (!(this.filename == null || this.filename.equals(""))) {
                    output.writeString(1, this.filename);
                }
                if (!Arrays.equals(this.sha256, WireFormatNano.EMPTY_BYTES)) {
                    output.writeBytes(2, this.sha256);
                }
                if (this.timeSec != 0) {
                    output.writeInt64(3, this.timeSec);
                }
                super.writeTo(output);
            }

            protected int computeSerializedSize() {
                int size = super.computeSerializedSize();
                if (!(this.filename == null || this.filename.equals(""))) {
                    size += CodedOutputByteBufferNano.computeStringSize(1, this.filename);
                }
                if (!Arrays.equals(this.sha256, WireFormatNano.EMPTY_BYTES)) {
                    size += CodedOutputByteBufferNano.computeBytesSize(2, this.sha256);
                }
                if (this.timeSec != 0) {
                    return size + CodedOutputByteBufferNano.computeInt64Size(3, this.timeSec);
                }
                return size;
            }

            public FileInfo mergeFrom(CodedInputByteBufferNano input) throws IOException {
                while (true) {
                    int tag = input.readTag();
                    switch (tag) {
                        case 0:
                            break;
                        case 10:
                            this.filename = input.readString();
                            continue;
                        case 18:
                            this.sha256 = input.readBytes();
                            continue;
                        case 24:
                            this.timeSec = input.readInt64();
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

        public static DalvikCacheInfo[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new DalvikCacheInfo[0];
                    }
                }
            }
            return _emptyArray;
        }

        public DalvikCacheInfo() {
            clear();
        }

        public DalvikCacheInfo clear() {
            this.changedFiles = FileInfo.emptyArray();
            this.unknownFieldData = null;
            this.cachedSize = -1;
            return this;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof DalvikCacheInfo)) {
                return false;
            }
            DalvikCacheInfo other = (DalvikCacheInfo) o;
            if (!InternalNano.equals(this.changedFiles, other.changedFiles)) {
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
            int hashCode = (((getClass().getName().hashCode() + 527) * 31) + InternalNano.hashCode(this.changedFiles)) * 31;
            if (this.unknownFieldData == null || this.unknownFieldData.isEmpty()) {
                i = 0;
            } else {
                i = this.unknownFieldData.hashCode();
            }
            return hashCode + i;
        }

        public void writeTo(CodedOutputByteBufferNano output) throws IOException {
            if (this.changedFiles != null && this.changedFiles.length > 0) {
                for (FileInfo element : this.changedFiles) {
                    if (element != null) {
                        output.writeMessage(1, element);
                    }
                }
            }
            super.writeTo(output);
        }

        protected int computeSerializedSize() {
            int size = super.computeSerializedSize();
            if (this.changedFiles != null && this.changedFiles.length > 0) {
                for (FileInfo element : this.changedFiles) {
                    if (element != null) {
                        size += CodedOutputByteBufferNano.computeMessageSize(1, element);
                    }
                }
            }
            return size;
        }

        public DalvikCacheInfo mergeFrom(CodedInputByteBufferNano input) throws IOException {
            while (true) {
                int tag = input.readTag();
                switch (tag) {
                    case 0:
                        break;
                    case 10:
                        int i;
                        int arrayLength = WireFormatNano.getRepeatedFieldArrayLength(input, 10);
                        if (this.changedFiles == null) {
                            i = 0;
                        } else {
                            i = this.changedFiles.length;
                        }
                        FileInfo[] newArray = new FileInfo[(i + arrayLength)];
                        if (i != 0) {
                            System.arraycopy(this.changedFiles, 0, newArray, 0, i);
                        }
                        while (i < newArray.length - 1) {
                            newArray[i] = new FileInfo();
                            input.readMessage(newArray[i]);
                            input.readTag();
                            i++;
                        }
                        newArray[i] = new FileInfo();
                        input.readMessage(newArray[i]);
                        this.changedFiles = newArray;
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

        public static DalvikCacheInfo parseFrom(byte[] data) throws InvalidProtocolBufferNanoException {
            return (DalvikCacheInfo) MessageNano.mergeFrom(new DalvikCacheInfo(), data);
        }

        public static DalvikCacheInfo parseFrom(CodedInputByteBufferNano input) throws IOException {
            return new DalvikCacheInfo().mergeFrom(input);
        }
    }

    public static final class DeviceState extends ExtendableMessageNano<DeviceState> {
        private static volatile DeviceState[] _emptyArray;
        public DMVerityCorrection[] dmVerityCorrection;
        public String kernelVersion;
        public int oemLocked;
        public int oemUnlockSupported;
        public String productBrand;
        public String productModel;
        public String securityPatchLevel;
        public SystemProperty[] systemProperty;
        public String verifiedBootState;
        public String verityMode;

        public static DeviceState[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new DeviceState[0];
                    }
                }
            }
            return _emptyArray;
        }

        public DeviceState() {
            clear();
        }

        public DeviceState clear() {
            this.verifiedBootState = "";
            this.verityMode = "";
            this.oemUnlockSupported = 0;
            this.oemLocked = 0;
            this.securityPatchLevel = "";
            this.dmVerityCorrection = DMVerityCorrection.emptyArray();
            this.productBrand = "";
            this.productModel = "";
            this.kernelVersion = "";
            this.systemProperty = SystemProperty.emptyArray();
            this.unknownFieldData = null;
            this.cachedSize = -1;
            return this;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof DeviceState)) {
                return false;
            }
            DeviceState other = (DeviceState) o;
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
            if (!InternalNano.equals(this.dmVerityCorrection, other.dmVerityCorrection)) {
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
            hashCode = (((hashCode + i) * 31) + InternalNano.hashCode(this.dmVerityCorrection)) * 31;
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
            if (this.dmVerityCorrection != null && this.dmVerityCorrection.length > 0) {
                for (DMVerityCorrection element : this.dmVerityCorrection) {
                    if (element != null) {
                        output.writeMessage(6, element);
                    }
                }
            }
            if (!(this.productBrand == null || this.productBrand.equals(""))) {
                output.writeString(7, this.productBrand);
            }
            if (!(this.productModel == null || this.productModel.equals(""))) {
                output.writeString(8, this.productModel);
            }
            if (!(this.kernelVersion == null || this.kernelVersion.equals(""))) {
                output.writeString(9, this.kernelVersion);
            }
            if (this.systemProperty != null && this.systemProperty.length > 0) {
                for (SystemProperty element2 : this.systemProperty) {
                    if (element2 != null) {
                        output.writeMessage(10, element2);
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
            if (this.dmVerityCorrection != null && this.dmVerityCorrection.length > 0) {
                for (DMVerityCorrection element : this.dmVerityCorrection) {
                    if (element != null) {
                        size += CodedOutputByteBufferNano.computeMessageSize(6, element);
                    }
                }
            }
            if (!(this.productBrand == null || this.productBrand.equals(""))) {
                size += CodedOutputByteBufferNano.computeStringSize(7, this.productBrand);
            }
            if (!(this.productModel == null || this.productModel.equals(""))) {
                size += CodedOutputByteBufferNano.computeStringSize(8, this.productModel);
            }
            if (!(this.kernelVersion == null || this.kernelVersion.equals(""))) {
                size += CodedOutputByteBufferNano.computeStringSize(9, this.kernelVersion);
            }
            if (this.systemProperty != null && this.systemProperty.length > 0) {
                for (SystemProperty element2 : this.systemProperty) {
                    if (element2 != null) {
                        size += CodedOutputByteBufferNano.computeMessageSize(10, element2);
                    }
                }
            }
            return size;
        }

        public DeviceState mergeFrom(CodedInputByteBufferNano input) throws IOException {
            while (true) {
                int tag = input.readTag();
                int arrayLength;
                int i;
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
                        arrayLength = WireFormatNano.getRepeatedFieldArrayLength(input, 50);
                        if (this.dmVerityCorrection == null) {
                            i = 0;
                        } else {
                            i = this.dmVerityCorrection.length;
                        }
                        DMVerityCorrection[] newArray = new DMVerityCorrection[(i + arrayLength)];
                        if (i != 0) {
                            System.arraycopy(this.dmVerityCorrection, 0, newArray, 0, i);
                        }
                        while (i < newArray.length - 1) {
                            newArray[i] = new DMVerityCorrection();
                            input.readMessage(newArray[i]);
                            input.readTag();
                            i++;
                        }
                        newArray[i] = new DMVerityCorrection();
                        input.readMessage(newArray[i]);
                        this.dmVerityCorrection = newArray;
                        continue;
                    case 58:
                        this.productBrand = input.readString();
                        continue;
                    case 66:
                        this.productModel = input.readString();
                        continue;
                    case 74:
                        this.kernelVersion = input.readString();
                        continue;
                    case 82:
                        arrayLength = WireFormatNano.getRepeatedFieldArrayLength(input, 82);
                        if (this.systemProperty == null) {
                            i = 0;
                        } else {
                            i = this.systemProperty.length;
                        }
                        SystemProperty[] newArray2 = new SystemProperty[(i + arrayLength)];
                        if (i != 0) {
                            System.arraycopy(this.systemProperty, 0, newArray2, 0, i);
                        }
                        while (i < newArray2.length - 1) {
                            newArray2[i] = new SystemProperty();
                            input.readMessage(newArray2[i]);
                            input.readTag();
                            i++;
                        }
                        newArray2[i] = new SystemProperty();
                        input.readMessage(newArray2[i]);
                        this.systemProperty = newArray2;
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

        public static DeviceState parseFrom(byte[] data) throws InvalidProtocolBufferNanoException {
            return (DeviceState) MessageNano.mergeFrom(new DeviceState(), data);
        }

        public static DeviceState parseFrom(CodedInputByteBufferNano input) throws IOException {
            return new DeviceState().mergeFrom(input);
        }
    }

    public static final class EventLog extends ExtendableMessageNano<EventLog> {
        private static volatile EventLog[] _emptyArray;
        public AppInfo[] appInfo;
        public String data;
        public String subTag;
        public int tag;
        public long timeNanos;

        public static EventLog[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new EventLog[0];
                    }
                }
            }
            return _emptyArray;
        }

        public EventLog() {
            clear();
        }

        public EventLog clear() {
            this.tag = 0;
            this.subTag = "";
            this.timeNanos = 0;
            this.appInfo = AppInfo.emptyArray();
            this.data = "";
            this.unknownFieldData = null;
            this.cachedSize = -1;
            return this;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof EventLog)) {
                return false;
            }
            EventLog other = (EventLog) o;
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
                for (AppInfo element : this.appInfo) {
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
                for (AppInfo element : this.appInfo) {
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

        public EventLog mergeFrom(CodedInputByteBufferNano input) throws IOException {
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
                        AppInfo[] newArray = new AppInfo[(i + arrayLength)];
                        if (i != 0) {
                            System.arraycopy(this.appInfo, 0, newArray, 0, i);
                        }
                        while (i < newArray.length - 1) {
                            newArray[i] = new AppInfo();
                            input.readMessage(newArray[i]);
                            input.readTag();
                            i++;
                        }
                        newArray[i] = new AppInfo();
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

        public static EventLog parseFrom(byte[] data) throws InvalidProtocolBufferNanoException {
            return (EventLog) MessageNano.mergeFrom(new EventLog(), data);
        }

        public static EventLog parseFrom(CodedInputByteBufferNano input) throws IOException {
            return new EventLog().mergeFrom(input);
        }
    }

    public static final class LogcatEntry extends ExtendableMessageNano<LogcatEntry> {
        private static volatile LogcatEntry[] _emptyArray;
        public String key;
        public LogcatValue[] value;

        public static LogcatEntry[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new LogcatEntry[0];
                    }
                }
            }
            return _emptyArray;
        }

        public LogcatEntry() {
            clear();
        }

        public LogcatEntry clear() {
            this.key = "";
            this.value = LogcatValue.emptyArray();
            this.unknownFieldData = null;
            this.cachedSize = -1;
            return this;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof LogcatEntry)) {
                return false;
            }
            LogcatEntry other = (LogcatEntry) o;
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
                for (LogcatValue element : this.value) {
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
                for (LogcatValue element : this.value) {
                    if (element != null) {
                        size += CodedOutputByteBufferNano.computeMessageSize(2, element);
                    }
                }
            }
            return size;
        }

        public LogcatEntry mergeFrom(CodedInputByteBufferNano input) throws IOException {
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
                        LogcatValue[] newArray = new LogcatValue[(i + arrayLength)];
                        if (i != 0) {
                            System.arraycopy(this.value, 0, newArray, 0, i);
                        }
                        while (i < newArray.length - 1) {
                            newArray[i] = new LogcatValue();
                            input.readMessage(newArray[i]);
                            input.readTag();
                            i++;
                        }
                        newArray[i] = new LogcatValue();
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

        public static LogcatEntry parseFrom(byte[] data) throws InvalidProtocolBufferNanoException {
            return (LogcatEntry) MessageNano.mergeFrom(new LogcatEntry(), data);
        }

        public static LogcatEntry parseFrom(CodedInputByteBufferNano input) throws IOException {
            return new LogcatEntry().mergeFrom(input);
        }
    }

    public static final class LogcatResults extends ExtendableMessageNano<LogcatResults> {
        private static volatile LogcatResults[] _emptyArray;
        public int numLogcatLines;
        public LogcatEntry[] results;

        public static LogcatResults[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new LogcatResults[0];
                    }
                }
            }
            return _emptyArray;
        }

        public LogcatResults() {
            clear();
        }

        public LogcatResults clear() {
            this.numLogcatLines = 0;
            this.results = LogcatEntry.emptyArray();
            this.unknownFieldData = null;
            this.cachedSize = -1;
            return this;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof LogcatResults)) {
                return false;
            }
            LogcatResults other = (LogcatResults) o;
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
                for (LogcatEntry element : this.results) {
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
                for (LogcatEntry element : this.results) {
                    if (element != null) {
                        size += CodedOutputByteBufferNano.computeMessageSize(2, element);
                    }
                }
            }
            return size;
        }

        public LogcatResults mergeFrom(CodedInputByteBufferNano input) throws IOException {
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
                        LogcatEntry[] newArray = new LogcatEntry[(i + arrayLength)];
                        if (i != 0) {
                            System.arraycopy(this.results, 0, newArray, 0, i);
                        }
                        while (i < newArray.length - 1) {
                            newArray[i] = new LogcatEntry();
                            input.readMessage(newArray[i]);
                            input.readTag();
                            i++;
                        }
                        newArray[i] = new LogcatEntry();
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

        public static LogcatResults parseFrom(byte[] data) throws InvalidProtocolBufferNanoException {
            return (LogcatResults) MessageNano.mergeFrom(new LogcatResults(), data);
        }

        public static LogcatResults parseFrom(CodedInputByteBufferNano input) throws IOException {
            return new LogcatResults().mergeFrom(input);
        }
    }

    public static final class LogcatValue extends ExtendableMessageNano<LogcatValue> {
        private static volatile LogcatValue[] _emptyArray;
        public AppInfo[] appInfo;
        public String line;

        public static LogcatValue[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new LogcatValue[0];
                    }
                }
            }
            return _emptyArray;
        }

        public LogcatValue() {
            clear();
        }

        public LogcatValue clear() {
            this.appInfo = AppInfo.emptyArray();
            this.line = "";
            this.unknownFieldData = null;
            this.cachedSize = -1;
            return this;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof LogcatValue)) {
                return false;
            }
            LogcatValue other = (LogcatValue) o;
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
                for (AppInfo element : this.appInfo) {
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
                for (AppInfo element : this.appInfo) {
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

        public LogcatValue mergeFrom(CodedInputByteBufferNano input) throws IOException {
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
                        AppInfo[] newArray = new AppInfo[(i + arrayLength)];
                        if (i != 0) {
                            System.arraycopy(this.appInfo, 0, newArray, 0, i);
                        }
                        while (i < newArray.length - 1) {
                            newArray[i] = new AppInfo();
                            input.readMessage(newArray[i]);
                            input.readTag();
                            i++;
                        }
                        newArray[i] = new AppInfo();
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

        public static LogcatValue parseFrom(byte[] data) throws InvalidProtocolBufferNanoException {
            return (LogcatValue) MessageNano.mergeFrom(new LogcatValue(), data);
        }

        public static LogcatValue parseFrom(CodedInputByteBufferNano input) throws IOException {
            return new LogcatValue().mergeFrom(input);
        }
    }

    public static final class RunSettings extends ExtendableMessageNano<RunSettings> {
        private static volatile RunSettings[] _emptyArray;
        public long durationSinceLastRunMs;
        public long executionTimeMs;
        public int numAttempts;
        public long wakeIntervalMs;

        public static RunSettings[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new RunSettings[0];
                    }
                }
            }
            return _emptyArray;
        }

        public RunSettings() {
            clear();
        }

        public RunSettings clear() {
            this.wakeIntervalMs = 0;
            this.durationSinceLastRunMs = 0;
            this.executionTimeMs = 0;
            this.numAttempts = 0;
            this.unknownFieldData = null;
            this.cachedSize = -1;
            return this;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof RunSettings)) {
                return false;
            }
            RunSettings other = (RunSettings) o;
            if (this.wakeIntervalMs != other.wakeIntervalMs || this.durationSinceLastRunMs != other.durationSinceLastRunMs || this.executionTimeMs != other.executionTimeMs || this.numAttempts != other.numAttempts) {
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
            int hashCode = (((((((((getClass().getName().hashCode() + 527) * 31) + ((int) (this.wakeIntervalMs ^ (this.wakeIntervalMs >>> 32)))) * 31) + ((int) (this.durationSinceLastRunMs ^ (this.durationSinceLastRunMs >>> 32)))) * 31) + ((int) (this.executionTimeMs ^ (this.executionTimeMs >>> 32)))) * 31) + this.numAttempts) * 31;
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
            if (this.numAttempts != 0) {
                output.writeInt32(4, this.numAttempts);
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
            if (this.numAttempts != 0) {
                return size + CodedOutputByteBufferNano.computeInt32Size(4, this.numAttempts);
            }
            return size;
        }

        public RunSettings mergeFrom(CodedInputByteBufferNano input) throws IOException {
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
                        this.numAttempts = input.readInt32();
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

        public static RunSettings parseFrom(byte[] data) throws InvalidProtocolBufferNanoException {
            return (RunSettings) MessageNano.mergeFrom(new RunSettings(), data);
        }

        public static RunSettings parseFrom(CodedInputByteBufferNano input) throws IOException {
            return new RunSettings().mergeFrom(input);
        }
    }

    public static final class SeLinuxInfo extends ExtendableMessageNano<SeLinuxInfo> {
        private static volatile SeLinuxInfo[] _emptyArray;
        public boolean enforcing;
        public boolean present;
        public byte[] selinuxPolicyHash;
        public String selinuxVersion;

        public static SeLinuxInfo[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new SeLinuxInfo[0];
                    }
                }
            }
            return _emptyArray;
        }

        public SeLinuxInfo() {
            clear();
        }

        public SeLinuxInfo clear() {
            this.present = false;
            this.enforcing = false;
            this.selinuxVersion = "";
            this.selinuxPolicyHash = WireFormatNano.EMPTY_BYTES;
            this.unknownFieldData = null;
            this.cachedSize = -1;
            return this;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof SeLinuxInfo)) {
                return false;
            }
            SeLinuxInfo other = (SeLinuxInfo) o;
            if (this.present != other.present || this.enforcing != other.enforcing) {
                return false;
            }
            if (this.selinuxVersion == null) {
                if (other.selinuxVersion != null) {
                    return false;
                }
            } else if (!this.selinuxVersion.equals(other.selinuxVersion)) {
                return false;
            }
            if (!Arrays.equals(this.selinuxPolicyHash, other.selinuxPolicyHash)) {
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
            if (!this.enforcing) {
                i = 1237;
            }
            i = (hashCode + i) * 31;
            if (this.selinuxVersion == null) {
                hashCode = 0;
            } else {
                hashCode = this.selinuxVersion.hashCode();
            }
            hashCode = (((i + hashCode) * 31) + Arrays.hashCode(this.selinuxPolicyHash)) * 31;
            if (!(this.unknownFieldData == null || this.unknownFieldData.isEmpty())) {
                i2 = this.unknownFieldData.hashCode();
            }
            return hashCode + i2;
        }

        public void writeTo(CodedOutputByteBufferNano output) throws IOException {
            if (this.present) {
                output.writeBool(1, this.present);
            }
            if (this.enforcing) {
                output.writeBool(2, this.enforcing);
            }
            if (!(this.selinuxVersion == null || this.selinuxVersion.equals(""))) {
                output.writeString(3, this.selinuxVersion);
            }
            if (!Arrays.equals(this.selinuxPolicyHash, WireFormatNano.EMPTY_BYTES)) {
                output.writeBytes(4, this.selinuxPolicyHash);
            }
            super.writeTo(output);
        }

        protected int computeSerializedSize() {
            int size = super.computeSerializedSize();
            if (this.present) {
                size += CodedOutputByteBufferNano.computeBoolSize(1, this.present);
            }
            if (this.enforcing) {
                size += CodedOutputByteBufferNano.computeBoolSize(2, this.enforcing);
            }
            if (!(this.selinuxVersion == null || this.selinuxVersion.equals(""))) {
                size += CodedOutputByteBufferNano.computeStringSize(3, this.selinuxVersion);
            }
            if (Arrays.equals(this.selinuxPolicyHash, WireFormatNano.EMPTY_BYTES)) {
                return size;
            }
            return size + CodedOutputByteBufferNano.computeBytesSize(4, this.selinuxPolicyHash);
        }

        public SeLinuxInfo mergeFrom(CodedInputByteBufferNano input) throws IOException {
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
                    case LogSource.ANDROID_CAMERA /*26*/:
                        this.selinuxVersion = input.readString();
                        continue;
                    case 34:
                        this.selinuxPolicyHash = input.readBytes();
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

        public static SeLinuxInfo parseFrom(byte[] data) throws InvalidProtocolBufferNanoException {
            return (SeLinuxInfo) MessageNano.mergeFrom(new SeLinuxInfo(), data);
        }

        public static SeLinuxInfo parseFrom(CodedInputByteBufferNano input) throws IOException {
            return new SeLinuxInfo().mergeFrom(input);
        }
    }

    public static final class SetuidFileInfo extends ExtendableMessageNano<SetuidFileInfo> {
        private static volatile SetuidFileInfo[] _emptyArray;
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

        public static SetuidFileInfo[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new SetuidFileInfo[0];
                    }
                }
            }
            return _emptyArray;
        }

        public SetuidFileInfo() {
            clear();
        }

        public SetuidFileInfo clear() {
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
            if (!(o instanceof SetuidFileInfo)) {
                return false;
            }
            SetuidFileInfo other = (SetuidFileInfo) o;
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

        public SetuidFileInfo mergeFrom(CodedInputByteBufferNano input) throws IOException {
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

        public static SetuidFileInfo parseFrom(byte[] data) throws InvalidProtocolBufferNanoException {
            return (SetuidFileInfo) MessageNano.mergeFrom(new SetuidFileInfo(), data);
        }

        public static SetuidFileInfo parseFrom(CodedInputByteBufferNano input) throws IOException {
            return new SetuidFileInfo().mergeFrom(input);
        }
    }

    public static final class SicFileInfo extends ExtendableMessageNano<SicFileInfo> {
        private static volatile SicFileInfo[] _emptyArray;
        public int fileGroup;
        public int fileOwner;
        public String path;
        public int permissions;
        public String seLinuxSecurityContext;
        public byte[] sha256;
        public boolean symlink;
        public String symlinkTarget;

        public static SicFileInfo[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new SicFileInfo[0];
                    }
                }
            }
            return _emptyArray;
        }

        public SicFileInfo() {
            clear();
        }

        public SicFileInfo clear() {
            this.path = "";
            this.sha256 = WireFormatNano.EMPTY_BYTES;
            this.symlink = false;
            this.symlinkTarget = "";
            this.permissions = 0;
            this.fileOwner = 0;
            this.fileGroup = 0;
            this.seLinuxSecurityContext = "";
            this.unknownFieldData = null;
            this.cachedSize = -1;
            return this;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof SicFileInfo)) {
                return false;
            }
            SicFileInfo other = (SicFileInfo) o;
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
            if (this.permissions != other.permissions || this.fileOwner != other.fileOwner || this.fileGroup != other.fileGroup) {
                return false;
            }
            if (this.seLinuxSecurityContext == null) {
                if (other.seLinuxSecurityContext != null) {
                    return false;
                }
            } else if (!this.seLinuxSecurityContext.equals(other.seLinuxSecurityContext)) {
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
            hashCode = (((((((hashCode + i) * 31) + this.permissions) * 31) + this.fileOwner) * 31) + this.fileGroup) * 31;
            if (this.seLinuxSecurityContext == null) {
                i = 0;
            } else {
                i = this.seLinuxSecurityContext.hashCode();
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
            if (!(this.symlinkTarget == null || this.symlinkTarget.equals(""))) {
                size += CodedOutputByteBufferNano.computeStringSize(4, this.symlinkTarget);
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
            if (this.seLinuxSecurityContext == null || this.seLinuxSecurityContext.equals("")) {
                return size;
            }
            return size + CodedOutputByteBufferNano.computeStringSize(8, this.seLinuxSecurityContext);
        }

        public SicFileInfo mergeFrom(CodedInputByteBufferNano input) throws IOException {
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
                    default:
                        if (!super.storeUnknownField(input, tag)) {
                            break;
                        }
                        continue;
                }
                return this;
            }
        }

        public static SicFileInfo parseFrom(byte[] data) throws InvalidProtocolBufferNanoException {
            return (SicFileInfo) MessageNano.mergeFrom(new SicFileInfo(), data);
        }

        public static SicFileInfo parseFrom(CodedInputByteBufferNano input) throws IOException {
            return new SicFileInfo().mergeFrom(input);
        }
    }

    public static final class SnetIdleLog extends ExtendableMessageNano<SnetIdleLog> {
        private static volatile SnetIdleLog[] _emptyArray;
        public String buildFingerprint;
        public AppInfo buildInfo;
        public String country;
        public DalvikCacheInfo dalvikCacheInfo;
        public String debugStatus;
        public DeviceState deviceState;
        public EventLog[] events;
        public byte[] featuresBitField;
        public AppInfo gmsCoreInfo;
        public boolean gmsCoreUuidUsed;
        public boolean isSidewinderDevice;
        public String[] jarExceptions;
        public long jarVersion;
        public String locale;
        public LogcatResults logcatResults;
        public RunSettings runSettings;
        public SeLinuxInfo seLinuxInfo;
        public SetuidFileInfo setuidFileInfo;
        public String sharedUuid;
        public String signalTagsWhitelist;
        public SystemCaCertStoreInfo[] systemCaCertStoreInfo;
        public SystemPartitionFileInfo systemPartitionFileInfo;
        public String uuid;

        public static SnetIdleLog[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new SnetIdleLog[0];
                    }
                }
            }
            return _emptyArray;
        }

        public SnetIdleLog() {
            clear();
        }

        public SnetIdleLog clear() {
            this.jarVersion = 0;
            this.gmsCoreUuidUsed = false;
            this.sharedUuid = "";
            this.uuid = "";
            this.jarExceptions = WireFormatNano.EMPTY_STRING_ARRAY;
            this.featuresBitField = WireFormatNano.EMPTY_BYTES;
            this.debugStatus = "";
            this.runSettings = null;
            this.signalTagsWhitelist = "";
            this.buildFingerprint = "";
            this.buildInfo = null;
            this.isSidewinderDevice = false;
            this.systemPartitionFileInfo = null;
            this.systemCaCertStoreInfo = SystemCaCertStoreInfo.emptyArray();
            this.setuidFileInfo = null;
            this.logcatResults = null;
            this.events = EventLog.emptyArray();
            this.dalvikCacheInfo = null;
            this.deviceState = null;
            this.locale = "";
            this.country = "";
            this.seLinuxInfo = null;
            this.gmsCoreInfo = null;
            this.unknownFieldData = null;
            this.cachedSize = -1;
            return this;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof SnetIdleLog)) {
                return false;
            }
            SnetIdleLog other = (SnetIdleLog) o;
            if (this.jarVersion != other.jarVersion || this.gmsCoreUuidUsed != other.gmsCoreUuidUsed) {
                return false;
            }
            if (this.sharedUuid == null) {
                if (other.sharedUuid != null) {
                    return false;
                }
            } else if (!this.sharedUuid.equals(other.sharedUuid)) {
                return false;
            }
            if (this.uuid == null) {
                if (other.uuid != null) {
                    return false;
                }
            } else if (!this.uuid.equals(other.uuid)) {
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
            if (this.buildFingerprint == null) {
                if (other.buildFingerprint != null) {
                    return false;
                }
            } else if (!this.buildFingerprint.equals(other.buildFingerprint)) {
                return false;
            }
            if (this.buildInfo == null) {
                if (other.buildInfo != null) {
                    return false;
                }
            } else if (!this.buildInfo.equals(other.buildInfo)) {
                return false;
            }
            if (this.isSidewinderDevice != other.isSidewinderDevice) {
                return false;
            }
            if (this.systemPartitionFileInfo == null) {
                if (other.systemPartitionFileInfo != null) {
                    return false;
                }
            } else if (!this.systemPartitionFileInfo.equals(other.systemPartitionFileInfo)) {
                return false;
            }
            if (!InternalNano.equals(this.systemCaCertStoreInfo, other.systemCaCertStoreInfo)) {
                return false;
            }
            if (this.setuidFileInfo == null) {
                if (other.setuidFileInfo != null) {
                    return false;
                }
            } else if (!this.setuidFileInfo.equals(other.setuidFileInfo)) {
                return false;
            }
            if (this.logcatResults == null) {
                if (other.logcatResults != null) {
                    return false;
                }
            } else if (!this.logcatResults.equals(other.logcatResults)) {
                return false;
            }
            if (!InternalNano.equals(this.events, other.events)) {
                return false;
            }
            if (this.dalvikCacheInfo == null) {
                if (other.dalvikCacheInfo != null) {
                    return false;
                }
            } else if (!this.dalvikCacheInfo.equals(other.dalvikCacheInfo)) {
                return false;
            }
            if (this.deviceState == null) {
                if (other.deviceState != null) {
                    return false;
                }
            } else if (!this.deviceState.equals(other.deviceState)) {
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
            if (this.seLinuxInfo == null) {
                if (other.seLinuxInfo != null) {
                    return false;
                }
            } else if (!this.seLinuxInfo.equals(other.seLinuxInfo)) {
                return false;
            }
            if (this.gmsCoreInfo == null) {
                if (other.gmsCoreInfo != null) {
                    return false;
                }
            } else if (!this.gmsCoreInfo.equals(other.gmsCoreInfo)) {
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
            int hashCode = (((((getClass().getName().hashCode() + 527) * 31) + ((int) (this.jarVersion ^ (this.jarVersion >>> 32)))) * 31) + (this.gmsCoreUuidUsed ? 1231 : 1237)) * 31;
            if (this.sharedUuid == null) {
                i = 0;
            } else {
                i = this.sharedUuid.hashCode();
            }
            hashCode = (hashCode + i) * 31;
            if (this.uuid == null) {
                i = 0;
            } else {
                i = this.uuid.hashCode();
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
            if (this.buildFingerprint == null) {
                i = 0;
            } else {
                i = this.buildFingerprint.hashCode();
            }
            hashCode = (hashCode + i) * 31;
            if (this.buildInfo == null) {
                i = 0;
            } else {
                i = this.buildInfo.hashCode();
            }
            i = (hashCode + i) * 31;
            if (!this.isSidewinderDevice) {
                i2 = 1237;
            }
            i2 = (i + i2) * 31;
            if (this.systemPartitionFileInfo == null) {
                i = 0;
            } else {
                i = this.systemPartitionFileInfo.hashCode();
            }
            i2 = (((i2 + i) * 31) + InternalNano.hashCode(this.systemCaCertStoreInfo)) * 31;
            if (this.setuidFileInfo == null) {
                i = 0;
            } else {
                i = this.setuidFileInfo.hashCode();
            }
            i2 = (i2 + i) * 31;
            if (this.logcatResults == null) {
                i = 0;
            } else {
                i = this.logcatResults.hashCode();
            }
            i2 = (((i2 + i) * 31) + InternalNano.hashCode(this.events)) * 31;
            if (this.dalvikCacheInfo == null) {
                i = 0;
            } else {
                i = this.dalvikCacheInfo.hashCode();
            }
            i2 = (i2 + i) * 31;
            if (this.deviceState == null) {
                i = 0;
            } else {
                i = this.deviceState.hashCode();
            }
            i2 = (i2 + i) * 31;
            if (this.locale == null) {
                i = 0;
            } else {
                i = this.locale.hashCode();
            }
            i2 = (i2 + i) * 31;
            if (this.country == null) {
                i = 0;
            } else {
                i = this.country.hashCode();
            }
            i2 = (i2 + i) * 31;
            if (this.seLinuxInfo == null) {
                i = 0;
            } else {
                i = this.seLinuxInfo.hashCode();
            }
            i2 = (i2 + i) * 31;
            if (this.gmsCoreInfo == null) {
                i = 0;
            } else {
                i = this.gmsCoreInfo.hashCode();
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
            if (this.gmsCoreUuidUsed) {
                output.writeBool(2, this.gmsCoreUuidUsed);
            }
            if (!(this.sharedUuid == null || this.sharedUuid.equals(""))) {
                output.writeString(3, this.sharedUuid);
            }
            if (!(this.uuid == null || this.uuid.equals(""))) {
                output.writeString(4, this.uuid);
            }
            if (this.jarExceptions != null && this.jarExceptions.length > 0) {
                for (String element : this.jarExceptions) {
                    if (element != null) {
                        output.writeString(5, element);
                    }
                }
            }
            if (!Arrays.equals(this.featuresBitField, WireFormatNano.EMPTY_BYTES)) {
                output.writeBytes(6, this.featuresBitField);
            }
            if (!(this.debugStatus == null || this.debugStatus.equals(""))) {
                output.writeString(7, this.debugStatus);
            }
            if (this.runSettings != null) {
                output.writeMessage(8, this.runSettings);
            }
            if (!(this.signalTagsWhitelist == null || this.signalTagsWhitelist.equals(""))) {
                output.writeString(9, this.signalTagsWhitelist);
            }
            if (!(this.buildFingerprint == null || this.buildFingerprint.equals(""))) {
                output.writeString(10, this.buildFingerprint);
            }
            if (this.systemPartitionFileInfo != null) {
                output.writeMessage(11, this.systemPartitionFileInfo);
            }
            if (this.systemCaCertStoreInfo != null && this.systemCaCertStoreInfo.length > 0) {
                for (SystemCaCertStoreInfo element2 : this.systemCaCertStoreInfo) {
                    if (element2 != null) {
                        output.writeMessage(12, element2);
                    }
                }
            }
            if (this.setuidFileInfo != null) {
                output.writeMessage(13, this.setuidFileInfo);
            }
            if (this.isSidewinderDevice) {
                output.writeBool(14, this.isSidewinderDevice);
            }
            if (this.logcatResults != null) {
                output.writeMessage(15, this.logcatResults);
            }
            if (this.events != null && this.events.length > 0) {
                for (EventLog element3 : this.events) {
                    if (element3 != null) {
                        output.writeMessage(16, element3);
                    }
                }
            }
            if (this.buildInfo != null) {
                output.writeMessage(17, this.buildInfo);
            }
            if (this.dalvikCacheInfo != null) {
                output.writeMessage(18, this.dalvikCacheInfo);
            }
            if (this.deviceState != null) {
                output.writeMessage(19, this.deviceState);
            }
            if (!(this.locale == null || this.locale.equals(""))) {
                output.writeString(20, this.locale);
            }
            if (!(this.country == null || this.country.equals(""))) {
                output.writeString(21, this.country);
            }
            if (this.seLinuxInfo != null) {
                output.writeMessage(22, this.seLinuxInfo);
            }
            if (this.gmsCoreInfo != null) {
                output.writeMessage(23, this.gmsCoreInfo);
            }
            super.writeTo(output);
        }

        protected int computeSerializedSize() {
            int size = super.computeSerializedSize();
            if (this.jarVersion != 0) {
                size += CodedOutputByteBufferNano.computeInt64Size(1, this.jarVersion);
            }
            if (this.gmsCoreUuidUsed) {
                size += CodedOutputByteBufferNano.computeBoolSize(2, this.gmsCoreUuidUsed);
            }
            if (!(this.sharedUuid == null || this.sharedUuid.equals(""))) {
                size += CodedOutputByteBufferNano.computeStringSize(3, this.sharedUuid);
            }
            if (!(this.uuid == null || this.uuid.equals(""))) {
                size += CodedOutputByteBufferNano.computeStringSize(4, this.uuid);
            }
            if (this.jarExceptions != null && this.jarExceptions.length > 0) {
                int dataCount = 0;
                int dataSize = 0;
                for (String element : this.jarExceptions) {
                    if (element != null) {
                        dataCount++;
                        dataSize += CodedOutputByteBufferNano.computeStringSizeNoTag(element);
                    }
                }
                size = (size + dataSize) + (dataCount * 1);
            }
            if (!Arrays.equals(this.featuresBitField, WireFormatNano.EMPTY_BYTES)) {
                size += CodedOutputByteBufferNano.computeBytesSize(6, this.featuresBitField);
            }
            if (!(this.debugStatus == null || this.debugStatus.equals(""))) {
                size += CodedOutputByteBufferNano.computeStringSize(7, this.debugStatus);
            }
            if (this.runSettings != null) {
                size += CodedOutputByteBufferNano.computeMessageSize(8, this.runSettings);
            }
            if (!(this.signalTagsWhitelist == null || this.signalTagsWhitelist.equals(""))) {
                size += CodedOutputByteBufferNano.computeStringSize(9, this.signalTagsWhitelist);
            }
            if (!(this.buildFingerprint == null || this.buildFingerprint.equals(""))) {
                size += CodedOutputByteBufferNano.computeStringSize(10, this.buildFingerprint);
            }
            if (this.systemPartitionFileInfo != null) {
                size += CodedOutputByteBufferNano.computeMessageSize(11, this.systemPartitionFileInfo);
            }
            if (this.systemCaCertStoreInfo != null && this.systemCaCertStoreInfo.length > 0) {
                for (SystemCaCertStoreInfo element2 : this.systemCaCertStoreInfo) {
                    if (element2 != null) {
                        size += CodedOutputByteBufferNano.computeMessageSize(12, element2);
                    }
                }
            }
            if (this.setuidFileInfo != null) {
                size += CodedOutputByteBufferNano.computeMessageSize(13, this.setuidFileInfo);
            }
            if (this.isSidewinderDevice) {
                size += CodedOutputByteBufferNano.computeBoolSize(14, this.isSidewinderDevice);
            }
            if (this.logcatResults != null) {
                size += CodedOutputByteBufferNano.computeMessageSize(15, this.logcatResults);
            }
            if (this.events != null && this.events.length > 0) {
                for (EventLog element3 : this.events) {
                    if (element3 != null) {
                        size += CodedOutputByteBufferNano.computeMessageSize(16, element3);
                    }
                }
            }
            if (this.buildInfo != null) {
                size += CodedOutputByteBufferNano.computeMessageSize(17, this.buildInfo);
            }
            if (this.dalvikCacheInfo != null) {
                size += CodedOutputByteBufferNano.computeMessageSize(18, this.dalvikCacheInfo);
            }
            if (this.deviceState != null) {
                size += CodedOutputByteBufferNano.computeMessageSize(19, this.deviceState);
            }
            if (!(this.locale == null || this.locale.equals(""))) {
                size += CodedOutputByteBufferNano.computeStringSize(20, this.locale);
            }
            if (!(this.country == null || this.country.equals(""))) {
                size += CodedOutputByteBufferNano.computeStringSize(21, this.country);
            }
            if (this.seLinuxInfo != null) {
                size += CodedOutputByteBufferNano.computeMessageSize(22, this.seLinuxInfo);
            }
            if (this.gmsCoreInfo != null) {
                return size + CodedOutputByteBufferNano.computeMessageSize(23, this.gmsCoreInfo);
            }
            return size;
        }

        public SnetIdleLog mergeFrom(CodedInputByteBufferNano input) throws IOException {
            while (true) {
                int tag = input.readTag();
                int arrayLength;
                int i;
                switch (tag) {
                    case 0:
                        break;
                    case 8:
                        this.jarVersion = input.readInt64();
                        continue;
                    case 16:
                        this.gmsCoreUuidUsed = input.readBool();
                        continue;
                    case LogSource.ANDROID_CAMERA /*26*/:
                        this.sharedUuid = input.readString();
                        continue;
                    case 34:
                        this.uuid = input.readString();
                        continue;
                    case MotionEventCompat.AXIS_GENERIC_11 /*42*/:
                        arrayLength = WireFormatNano.getRepeatedFieldArrayLength(input, 42);
                        i = this.jarExceptions == null ? 0 : this.jarExceptions.length;
                        String[] newArray = new String[(i + arrayLength)];
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
                    case 50:
                        this.featuresBitField = input.readBytes();
                        continue;
                    case 58:
                        this.debugStatus = input.readString();
                        continue;
                    case 66:
                        if (this.runSettings == null) {
                            this.runSettings = new RunSettings();
                        }
                        input.readMessage(this.runSettings);
                        continue;
                    case 74:
                        this.signalTagsWhitelist = input.readString();
                        continue;
                    case 82:
                        this.buildFingerprint = input.readString();
                        continue;
                    case 90:
                        if (this.systemPartitionFileInfo == null) {
                            this.systemPartitionFileInfo = new SystemPartitionFileInfo();
                        }
                        input.readMessage(this.systemPartitionFileInfo);
                        continue;
                    case 98:
                        arrayLength = WireFormatNano.getRepeatedFieldArrayLength(input, 98);
                        if (this.systemCaCertStoreInfo == null) {
                            i = 0;
                        } else {
                            i = this.systemCaCertStoreInfo.length;
                        }
                        SystemCaCertStoreInfo[] newArray2 = new SystemCaCertStoreInfo[(i + arrayLength)];
                        if (i != 0) {
                            System.arraycopy(this.systemCaCertStoreInfo, 0, newArray2, 0, i);
                        }
                        while (i < newArray2.length - 1) {
                            newArray2[i] = new SystemCaCertStoreInfo();
                            input.readMessage(newArray2[i]);
                            input.readTag();
                            i++;
                        }
                        newArray2[i] = new SystemCaCertStoreInfo();
                        input.readMessage(newArray2[i]);
                        this.systemCaCertStoreInfo = newArray2;
                        continue;
                    case 106:
                        if (this.setuidFileInfo == null) {
                            this.setuidFileInfo = new SetuidFileInfo();
                        }
                        input.readMessage(this.setuidFileInfo);
                        continue;
                    case 112:
                        this.isSidewinderDevice = input.readBool();
                        continue;
                    case 122:
                        if (this.logcatResults == null) {
                            this.logcatResults = new LogcatResults();
                        }
                        input.readMessage(this.logcatResults);
                        continue;
                    case TransportMediator.KEYCODE_MEDIA_RECORD /*130*/:
                        arrayLength = WireFormatNano.getRepeatedFieldArrayLength(input, TransportMediator.KEYCODE_MEDIA_RECORD);
                        if (this.events == null) {
                            i = 0;
                        } else {
                            i = this.events.length;
                        }
                        EventLog[] newArray3 = new EventLog[(i + arrayLength)];
                        if (i != 0) {
                            System.arraycopy(this.events, 0, newArray3, 0, i);
                        }
                        while (i < newArray3.length - 1) {
                            newArray3[i] = new EventLog();
                            input.readMessage(newArray3[i]);
                            input.readTag();
                            i++;
                        }
                        newArray3[i] = new EventLog();
                        input.readMessage(newArray3[i]);
                        this.events = newArray3;
                        continue;
                    case 138:
                        if (this.buildInfo == null) {
                            this.buildInfo = new AppInfo();
                        }
                        input.readMessage(this.buildInfo);
                        continue;
                    case 146:
                        if (this.dalvikCacheInfo == null) {
                            this.dalvikCacheInfo = new DalvikCacheInfo();
                        }
                        input.readMessage(this.dalvikCacheInfo);
                        continue;
                    case 154:
                        if (this.deviceState == null) {
                            this.deviceState = new DeviceState();
                        }
                        input.readMessage(this.deviceState);
                        continue;
                    case 162:
                        this.locale = input.readString();
                        continue;
                    case 170:
                        this.country = input.readString();
                        continue;
                    case 178:
                        if (this.seLinuxInfo == null) {
                            this.seLinuxInfo = new SeLinuxInfo();
                        }
                        input.readMessage(this.seLinuxInfo);
                        continue;
                    case 186:
                        if (this.gmsCoreInfo == null) {
                            this.gmsCoreInfo = new AppInfo();
                        }
                        input.readMessage(this.gmsCoreInfo);
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

        public static SnetIdleLog parseFrom(byte[] data) throws InvalidProtocolBufferNanoException {
            return (SnetIdleLog) MessageNano.mergeFrom(new SnetIdleLog(), data);
        }

        public static SnetIdleLog parseFrom(CodedInputByteBufferNano input) throws IOException {
            return new SnetIdleLog().mergeFrom(input);
        }
    }

    public static final class SystemCaCertStoreInfo extends ExtendableMessageNano<SystemCaCertStoreInfo> {
        private static volatile SystemCaCertStoreInfo[] _emptyArray;
        public String certOid;
        public byte[] certText;
        public byte[] certTextSha256;
        public byte[] derEncodedCert;
        public byte[] derEncodedCertSha256;
        public String issuerDn;
        public String subjectDn;
        public byte[] subjectPublicKeyInfo;
        public byte[] subjectPublicKeyInfoSha256;

        public static SystemCaCertStoreInfo[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new SystemCaCertStoreInfo[0];
                    }
                }
            }
            return _emptyArray;
        }

        public SystemCaCertStoreInfo() {
            clear();
        }

        public SystemCaCertStoreInfo clear() {
            this.subjectDn = "";
            this.issuerDn = "";
            this.certTextSha256 = WireFormatNano.EMPTY_BYTES;
            this.certText = WireFormatNano.EMPTY_BYTES;
            this.derEncodedCertSha256 = WireFormatNano.EMPTY_BYTES;
            this.derEncodedCert = WireFormatNano.EMPTY_BYTES;
            this.subjectPublicKeyInfo = WireFormatNano.EMPTY_BYTES;
            this.certOid = "";
            this.subjectPublicKeyInfoSha256 = WireFormatNano.EMPTY_BYTES;
            this.unknownFieldData = null;
            this.cachedSize = -1;
            return this;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof SystemCaCertStoreInfo)) {
                return false;
            }
            SystemCaCertStoreInfo other = (SystemCaCertStoreInfo) o;
            if (this.subjectDn == null) {
                if (other.subjectDn != null) {
                    return false;
                }
            } else if (!this.subjectDn.equals(other.subjectDn)) {
                return false;
            }
            if (this.issuerDn == null) {
                if (other.issuerDn != null) {
                    return false;
                }
            } else if (!this.issuerDn.equals(other.issuerDn)) {
                return false;
            }
            if (!Arrays.equals(this.certTextSha256, other.certTextSha256) || !Arrays.equals(this.certText, other.certText) || !Arrays.equals(this.derEncodedCertSha256, other.derEncodedCertSha256) || !Arrays.equals(this.derEncodedCert, other.derEncodedCert) || !Arrays.equals(this.subjectPublicKeyInfo, other.subjectPublicKeyInfo)) {
                return false;
            }
            if (this.certOid == null) {
                if (other.certOid != null) {
                    return false;
                }
            } else if (!this.certOid.equals(other.certOid)) {
                return false;
            }
            if (!Arrays.equals(this.subjectPublicKeyInfoSha256, other.subjectPublicKeyInfoSha256)) {
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
            if (this.subjectDn == null) {
                i = 0;
            } else {
                i = this.subjectDn.hashCode();
            }
            hashCode = (hashCode + i) * 31;
            if (this.issuerDn == null) {
                i = 0;
            } else {
                i = this.issuerDn.hashCode();
            }
            hashCode = (((((((((((hashCode + i) * 31) + Arrays.hashCode(this.certTextSha256)) * 31) + Arrays.hashCode(this.certText)) * 31) + Arrays.hashCode(this.derEncodedCertSha256)) * 31) + Arrays.hashCode(this.derEncodedCert)) * 31) + Arrays.hashCode(this.subjectPublicKeyInfo)) * 31;
            if (this.certOid == null) {
                i = 0;
            } else {
                i = this.certOid.hashCode();
            }
            i = (((hashCode + i) * 31) + Arrays.hashCode(this.subjectPublicKeyInfoSha256)) * 31;
            if (!(this.unknownFieldData == null || this.unknownFieldData.isEmpty())) {
                i2 = this.unknownFieldData.hashCode();
            }
            return i + i2;
        }

        public void writeTo(CodedOutputByteBufferNano output) throws IOException {
            if (!(this.subjectDn == null || this.subjectDn.equals(""))) {
                output.writeString(1, this.subjectDn);
            }
            if (!(this.issuerDn == null || this.issuerDn.equals(""))) {
                output.writeString(2, this.issuerDn);
            }
            if (!Arrays.equals(this.certTextSha256, WireFormatNano.EMPTY_BYTES)) {
                output.writeBytes(3, this.certTextSha256);
            }
            if (!Arrays.equals(this.certText, WireFormatNano.EMPTY_BYTES)) {
                output.writeBytes(4, this.certText);
            }
            if (!Arrays.equals(this.derEncodedCertSha256, WireFormatNano.EMPTY_BYTES)) {
                output.writeBytes(5, this.derEncodedCertSha256);
            }
            if (!Arrays.equals(this.derEncodedCert, WireFormatNano.EMPTY_BYTES)) {
                output.writeBytes(6, this.derEncodedCert);
            }
            if (!Arrays.equals(this.subjectPublicKeyInfo, WireFormatNano.EMPTY_BYTES)) {
                output.writeBytes(7, this.subjectPublicKeyInfo);
            }
            if (!(this.certOid == null || this.certOid.equals(""))) {
                output.writeString(8, this.certOid);
            }
            if (!Arrays.equals(this.subjectPublicKeyInfoSha256, WireFormatNano.EMPTY_BYTES)) {
                output.writeBytes(9, this.subjectPublicKeyInfoSha256);
            }
            super.writeTo(output);
        }

        protected int computeSerializedSize() {
            int size = super.computeSerializedSize();
            if (!(this.subjectDn == null || this.subjectDn.equals(""))) {
                size += CodedOutputByteBufferNano.computeStringSize(1, this.subjectDn);
            }
            if (!(this.issuerDn == null || this.issuerDn.equals(""))) {
                size += CodedOutputByteBufferNano.computeStringSize(2, this.issuerDn);
            }
            if (!Arrays.equals(this.certTextSha256, WireFormatNano.EMPTY_BYTES)) {
                size += CodedOutputByteBufferNano.computeBytesSize(3, this.certTextSha256);
            }
            if (!Arrays.equals(this.certText, WireFormatNano.EMPTY_BYTES)) {
                size += CodedOutputByteBufferNano.computeBytesSize(4, this.certText);
            }
            if (!Arrays.equals(this.derEncodedCertSha256, WireFormatNano.EMPTY_BYTES)) {
                size += CodedOutputByteBufferNano.computeBytesSize(5, this.derEncodedCertSha256);
            }
            if (!Arrays.equals(this.derEncodedCert, WireFormatNano.EMPTY_BYTES)) {
                size += CodedOutputByteBufferNano.computeBytesSize(6, this.derEncodedCert);
            }
            if (!Arrays.equals(this.subjectPublicKeyInfo, WireFormatNano.EMPTY_BYTES)) {
                size += CodedOutputByteBufferNano.computeBytesSize(7, this.subjectPublicKeyInfo);
            }
            if (!(this.certOid == null || this.certOid.equals(""))) {
                size += CodedOutputByteBufferNano.computeStringSize(8, this.certOid);
            }
            if (Arrays.equals(this.subjectPublicKeyInfoSha256, WireFormatNano.EMPTY_BYTES)) {
                return size;
            }
            return size + CodedOutputByteBufferNano.computeBytesSize(9, this.subjectPublicKeyInfoSha256);
        }

        public SystemCaCertStoreInfo mergeFrom(CodedInputByteBufferNano input) throws IOException {
            while (true) {
                int tag = input.readTag();
                switch (tag) {
                    case 0:
                        break;
                    case 10:
                        this.subjectDn = input.readString();
                        continue;
                    case 18:
                        this.issuerDn = input.readString();
                        continue;
                    case LogSource.ANDROID_CAMERA /*26*/:
                        this.certTextSha256 = input.readBytes();
                        continue;
                    case 34:
                        this.certText = input.readBytes();
                        continue;
                    case MotionEventCompat.AXIS_GENERIC_11 /*42*/:
                        this.derEncodedCertSha256 = input.readBytes();
                        continue;
                    case 50:
                        this.derEncodedCert = input.readBytes();
                        continue;
                    case 58:
                        this.subjectPublicKeyInfo = input.readBytes();
                        continue;
                    case 66:
                        this.certOid = input.readString();
                        continue;
                    case 74:
                        this.subjectPublicKeyInfoSha256 = input.readBytes();
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

        public static SystemCaCertStoreInfo parseFrom(byte[] data) throws InvalidProtocolBufferNanoException {
            return (SystemCaCertStoreInfo) MessageNano.mergeFrom(new SystemCaCertStoreInfo(), data);
        }

        public static SystemCaCertStoreInfo parseFrom(CodedInputByteBufferNano input) throws IOException {
            return new SystemCaCertStoreInfo().mergeFrom(input);
        }
    }

    public static final class SystemCaStoreWhitelist extends ExtendableMessageNano<SystemCaStoreWhitelist> {
        private static volatile SystemCaStoreWhitelist[] _emptyArray;
        public byte[][] subjectPublicKeyInfoSha256;

        public static SystemCaStoreWhitelist[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new SystemCaStoreWhitelist[0];
                    }
                }
            }
            return _emptyArray;
        }

        public SystemCaStoreWhitelist() {
            clear();
        }

        public SystemCaStoreWhitelist clear() {
            this.subjectPublicKeyInfoSha256 = WireFormatNano.EMPTY_BYTES_ARRAY;
            this.unknownFieldData = null;
            this.cachedSize = -1;
            return this;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof SystemCaStoreWhitelist)) {
                return false;
            }
            SystemCaStoreWhitelist other = (SystemCaStoreWhitelist) o;
            if (!InternalNano.equals(this.subjectPublicKeyInfoSha256, other.subjectPublicKeyInfoSha256)) {
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
            int hashCode = (((getClass().getName().hashCode() + 527) * 31) + InternalNano.hashCode(this.subjectPublicKeyInfoSha256)) * 31;
            if (this.unknownFieldData == null || this.unknownFieldData.isEmpty()) {
                i = 0;
            } else {
                i = this.unknownFieldData.hashCode();
            }
            return hashCode + i;
        }

        public void writeTo(CodedOutputByteBufferNano output) throws IOException {
            if (this.subjectPublicKeyInfoSha256 != null && this.subjectPublicKeyInfoSha256.length > 0) {
                for (byte[] element : this.subjectPublicKeyInfoSha256) {
                    if (element != null) {
                        output.writeBytes(1, element);
                    }
                }
            }
            super.writeTo(output);
        }

        protected int computeSerializedSize() {
            int size = super.computeSerializedSize();
            if (this.subjectPublicKeyInfoSha256 == null || this.subjectPublicKeyInfoSha256.length <= 0) {
                return size;
            }
            int dataCount = 0;
            int dataSize = 0;
            for (byte[] element : this.subjectPublicKeyInfoSha256) {
                if (element != null) {
                    dataCount++;
                    dataSize += CodedOutputByteBufferNano.computeBytesSizeNoTag(element);
                }
            }
            return (size + dataSize) + (dataCount * 1);
        }

        public SystemCaStoreWhitelist mergeFrom(CodedInputByteBufferNano input) throws IOException {
            while (true) {
                int tag = input.readTag();
                switch (tag) {
                    case 0:
                        break;
                    case 10:
                        int arrayLength = WireFormatNano.getRepeatedFieldArrayLength(input, 10);
                        int i = this.subjectPublicKeyInfoSha256 == null ? 0 : this.subjectPublicKeyInfoSha256.length;
                        byte[][] newArray = new byte[(i + arrayLength)][];
                        if (i != 0) {
                            System.arraycopy(this.subjectPublicKeyInfoSha256, 0, newArray, 0, i);
                        }
                        while (i < newArray.length - 1) {
                            newArray[i] = input.readBytes();
                            input.readTag();
                            i++;
                        }
                        newArray[i] = input.readBytes();
                        this.subjectPublicKeyInfoSha256 = newArray;
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

        public static SystemCaStoreWhitelist parseFrom(byte[] data) throws InvalidProtocolBufferNanoException {
            return (SystemCaStoreWhitelist) MessageNano.mergeFrom(new SystemCaStoreWhitelist(), data);
        }

        public static SystemCaStoreWhitelist parseFrom(CodedInputByteBufferNano input) throws IOException {
            return new SystemCaStoreWhitelist().mergeFrom(input);
        }
    }

    public static final class SystemIntegrityFileToUpload extends ExtendableMessageNano<SystemIntegrityFileToUpload> {
        private static volatile SystemIntegrityFileToUpload[] _emptyArray;
        public String filePath;
        public byte[] hash;

        public static SystemIntegrityFileToUpload[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new SystemIntegrityFileToUpload[0];
                    }
                }
            }
            return _emptyArray;
        }

        public SystemIntegrityFileToUpload() {
            clear();
        }

        public SystemIntegrityFileToUpload clear() {
            this.filePath = "";
            this.hash = WireFormatNano.EMPTY_BYTES;
            this.unknownFieldData = null;
            this.cachedSize = -1;
            return this;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof SystemIntegrityFileToUpload)) {
                return false;
            }
            SystemIntegrityFileToUpload other = (SystemIntegrityFileToUpload) o;
            if (this.filePath == null) {
                if (other.filePath != null) {
                    return false;
                }
            } else if (!this.filePath.equals(other.filePath)) {
                return false;
            }
            if (!Arrays.equals(this.hash, other.hash)) {
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
            if (this.filePath == null) {
                i = 0;
            } else {
                i = this.filePath.hashCode();
            }
            i = (((hashCode + i) * 31) + Arrays.hashCode(this.hash)) * 31;
            if (!(this.unknownFieldData == null || this.unknownFieldData.isEmpty())) {
                i2 = this.unknownFieldData.hashCode();
            }
            return i + i2;
        }

        public void writeTo(CodedOutputByteBufferNano output) throws IOException {
            if (!(this.filePath == null || this.filePath.equals(""))) {
                output.writeString(1, this.filePath);
            }
            if (!Arrays.equals(this.hash, WireFormatNano.EMPTY_BYTES)) {
                output.writeBytes(2, this.hash);
            }
            super.writeTo(output);
        }

        protected int computeSerializedSize() {
            int size = super.computeSerializedSize();
            if (!(this.filePath == null || this.filePath.equals(""))) {
                size += CodedOutputByteBufferNano.computeStringSize(1, this.filePath);
            }
            if (Arrays.equals(this.hash, WireFormatNano.EMPTY_BYTES)) {
                return size;
            }
            return size + CodedOutputByteBufferNano.computeBytesSize(2, this.hash);
        }

        public SystemIntegrityFileToUpload mergeFrom(CodedInputByteBufferNano input) throws IOException {
            while (true) {
                int tag = input.readTag();
                switch (tag) {
                    case 0:
                        break;
                    case 10:
                        this.filePath = input.readString();
                        continue;
                    case 18:
                        this.hash = input.readBytes();
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

        public static SystemIntegrityFileToUpload parseFrom(byte[] data) throws InvalidProtocolBufferNanoException {
            return (SystemIntegrityFileToUpload) MessageNano.mergeFrom(new SystemIntegrityFileToUpload(), data);
        }

        public static SystemIntegrityFileToUpload parseFrom(CodedInputByteBufferNano input) throws IOException {
            return new SystemIntegrityFileToUpload().mergeFrom(input);
        }
    }

    public static final class SystemIntegrityRequest extends ExtendableMessageNano<SystemIntegrityRequest> {
        private static volatile SystemIntegrityRequest[] _emptyArray;
        public String buildString;
        public SicFileInfo[] nodes;
        public byte[] sessionToken;
        public byte[] topLevelHash;

        public static SystemIntegrityRequest[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new SystemIntegrityRequest[0];
                    }
                }
            }
            return _emptyArray;
        }

        public SystemIntegrityRequest() {
            clear();
        }

        public SystemIntegrityRequest clear() {
            this.buildString = "";
            this.topLevelHash = WireFormatNano.EMPTY_BYTES;
            this.sessionToken = WireFormatNano.EMPTY_BYTES;
            this.nodes = SicFileInfo.emptyArray();
            this.unknownFieldData = null;
            this.cachedSize = -1;
            return this;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof SystemIntegrityRequest)) {
                return false;
            }
            SystemIntegrityRequest other = (SystemIntegrityRequest) o;
            if (this.buildString == null) {
                if (other.buildString != null) {
                    return false;
                }
            } else if (!this.buildString.equals(other.buildString)) {
                return false;
            }
            if (!Arrays.equals(this.topLevelHash, other.topLevelHash) || !Arrays.equals(this.sessionToken, other.sessionToken) || !InternalNano.equals(this.nodes, other.nodes)) {
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
            if (this.buildString == null) {
                i = 0;
            } else {
                i = this.buildString.hashCode();
            }
            i = (((((((hashCode + i) * 31) + Arrays.hashCode(this.topLevelHash)) * 31) + Arrays.hashCode(this.sessionToken)) * 31) + InternalNano.hashCode(this.nodes)) * 31;
            if (!(this.unknownFieldData == null || this.unknownFieldData.isEmpty())) {
                i2 = this.unknownFieldData.hashCode();
            }
            return i + i2;
        }

        public void writeTo(CodedOutputByteBufferNano output) throws IOException {
            if (!(this.buildString == null || this.buildString.equals(""))) {
                output.writeString(1, this.buildString);
            }
            if (!Arrays.equals(this.topLevelHash, WireFormatNano.EMPTY_BYTES)) {
                output.writeBytes(2, this.topLevelHash);
            }
            if (!Arrays.equals(this.sessionToken, WireFormatNano.EMPTY_BYTES)) {
                output.writeBytes(3, this.sessionToken);
            }
            if (this.nodes != null && this.nodes.length > 0) {
                for (SicFileInfo element : this.nodes) {
                    if (element != null) {
                        output.writeMessage(4, element);
                    }
                }
            }
            super.writeTo(output);
        }

        protected int computeSerializedSize() {
            int size = super.computeSerializedSize();
            if (!(this.buildString == null || this.buildString.equals(""))) {
                size += CodedOutputByteBufferNano.computeStringSize(1, this.buildString);
            }
            if (!Arrays.equals(this.topLevelHash, WireFormatNano.EMPTY_BYTES)) {
                size += CodedOutputByteBufferNano.computeBytesSize(2, this.topLevelHash);
            }
            if (!Arrays.equals(this.sessionToken, WireFormatNano.EMPTY_BYTES)) {
                size += CodedOutputByteBufferNano.computeBytesSize(3, this.sessionToken);
            }
            if (this.nodes != null && this.nodes.length > 0) {
                for (SicFileInfo element : this.nodes) {
                    if (element != null) {
                        size += CodedOutputByteBufferNano.computeMessageSize(4, element);
                    }
                }
            }
            return size;
        }

        public SystemIntegrityRequest mergeFrom(CodedInputByteBufferNano input) throws IOException {
            while (true) {
                int tag = input.readTag();
                switch (tag) {
                    case 0:
                        break;
                    case 10:
                        this.buildString = input.readString();
                        continue;
                    case 18:
                        this.topLevelHash = input.readBytes();
                        continue;
                    case LogSource.ANDROID_CAMERA /*26*/:
                        this.sessionToken = input.readBytes();
                        continue;
                    case 34:
                        int i;
                        int arrayLength = WireFormatNano.getRepeatedFieldArrayLength(input, 34);
                        if (this.nodes == null) {
                            i = 0;
                        } else {
                            i = this.nodes.length;
                        }
                        SicFileInfo[] newArray = new SicFileInfo[(i + arrayLength)];
                        if (i != 0) {
                            System.arraycopy(this.nodes, 0, newArray, 0, i);
                        }
                        while (i < newArray.length - 1) {
                            newArray[i] = new SicFileInfo();
                            input.readMessage(newArray[i]);
                            input.readTag();
                            i++;
                        }
                        newArray[i] = new SicFileInfo();
                        input.readMessage(newArray[i]);
                        this.nodes = newArray;
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

        public static SystemIntegrityRequest parseFrom(byte[] data) throws InvalidProtocolBufferNanoException {
            return (SystemIntegrityRequest) MessageNano.mergeFrom(new SystemIntegrityRequest(), data);
        }

        public static SystemIntegrityRequest parseFrom(CodedInputByteBufferNano input) throws IOException {
            return new SystemIntegrityRequest().mergeFrom(input);
        }
    }

    public static final class SystemIntegrityResponse extends ExtendableMessageNano<SystemIntegrityResponse> {
        private static volatile SystemIntegrityResponse[] _emptyArray;
        public SystemIntegrityFileToUpload[] filesToUpload;
        public int[] hashMatches;
        public boolean newBuildString;
        public byte[] sessionToken;

        public static SystemIntegrityResponse[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new SystemIntegrityResponse[0];
                    }
                }
            }
            return _emptyArray;
        }

        public SystemIntegrityResponse() {
            clear();
        }

        public SystemIntegrityResponse clear() {
            this.sessionToken = WireFormatNano.EMPTY_BYTES;
            this.newBuildString = false;
            this.hashMatches = WireFormatNano.EMPTY_INT_ARRAY;
            this.filesToUpload = SystemIntegrityFileToUpload.emptyArray();
            this.unknownFieldData = null;
            this.cachedSize = -1;
            return this;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof SystemIntegrityResponse)) {
                return false;
            }
            SystemIntegrityResponse other = (SystemIntegrityResponse) o;
            if (!Arrays.equals(this.sessionToken, other.sessionToken) || this.newBuildString != other.newBuildString || !InternalNano.equals(this.hashMatches, other.hashMatches) || !InternalNano.equals(this.filesToUpload, other.filesToUpload)) {
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
            int hashCode = (((((((((getClass().getName().hashCode() + 527) * 31) + Arrays.hashCode(this.sessionToken)) * 31) + (this.newBuildString ? 1231 : 1237)) * 31) + InternalNano.hashCode(this.hashMatches)) * 31) + InternalNano.hashCode(this.filesToUpload)) * 31;
            if (this.unknownFieldData == null || this.unknownFieldData.isEmpty()) {
                i = 0;
            } else {
                i = this.unknownFieldData.hashCode();
            }
            return hashCode + i;
        }

        public void writeTo(CodedOutputByteBufferNano output) throws IOException {
            if (!Arrays.equals(this.sessionToken, WireFormatNano.EMPTY_BYTES)) {
                output.writeBytes(1, this.sessionToken);
            }
            if (this.newBuildString) {
                output.writeBool(2, this.newBuildString);
            }
            if (this.hashMatches != null && this.hashMatches.length > 0) {
                for (int writeInt32 : this.hashMatches) {
                    output.writeInt32(3, writeInt32);
                }
            }
            if (this.filesToUpload != null && this.filesToUpload.length > 0) {
                for (SystemIntegrityFileToUpload element : this.filesToUpload) {
                    if (element != null) {
                        output.writeMessage(4, element);
                    }
                }
            }
            super.writeTo(output);
        }

        protected int computeSerializedSize() {
            int size = super.computeSerializedSize();
            if (!Arrays.equals(this.sessionToken, WireFormatNano.EMPTY_BYTES)) {
                size += CodedOutputByteBufferNano.computeBytesSize(1, this.sessionToken);
            }
            if (this.newBuildString) {
                size += CodedOutputByteBufferNano.computeBoolSize(2, this.newBuildString);
            }
            if (this.hashMatches != null && this.hashMatches.length > 0) {
                int dataSize = 0;
                for (int element : this.hashMatches) {
                    dataSize += CodedOutputByteBufferNano.computeInt32SizeNoTag(element);
                }
                size = (size + dataSize) + (this.hashMatches.length * 1);
            }
            if (this.filesToUpload != null && this.filesToUpload.length > 0) {
                for (SystemIntegrityFileToUpload element2 : this.filesToUpload) {
                    if (element2 != null) {
                        size += CodedOutputByteBufferNano.computeMessageSize(4, element2);
                    }
                }
            }
            return size;
        }

        public SystemIntegrityResponse mergeFrom(CodedInputByteBufferNano input) throws IOException {
            while (true) {
                int tag = input.readTag();
                int i;
                int value;
                int[] newArray;
                int arrayLength;
                switch (tag) {
                    case 0:
                        break;
                    case 10:
                        this.sessionToken = input.readBytes();
                        continue;
                    case 16:
                        this.newBuildString = input.readBool();
                        continue;
                    case 24:
                        int length = WireFormatNano.getRepeatedFieldArrayLength(input, 24);
                        int[] validValues = new int[length];
                        i = 0;
                        int validCount = 0;
                        while (i < length) {
                            int validCount2;
                            if (i != 0) {
                                input.readTag();
                            }
                            value = input.readInt32();
                            switch (value) {
                                case 0:
                                case 1:
                                case 2:
                                case 3:
                                    validCount2 = validCount + 1;
                                    validValues[validCount] = value;
                                    break;
                                default:
                                    validCount2 = validCount;
                                    break;
                            }
                            i++;
                            validCount = validCount2;
                        }
                        if (validCount != 0) {
                            i = this.hashMatches == null ? 0 : this.hashMatches.length;
                            if (i != 0 || validCount != validValues.length) {
                                newArray = new int[(i + validCount)];
                                if (i != 0) {
                                    System.arraycopy(this.hashMatches, 0, newArray, 0, i);
                                }
                                System.arraycopy(validValues, 0, newArray, i, validCount);
                                this.hashMatches = newArray;
                                break;
                            }
                            this.hashMatches = validValues;
                            break;
                        }
                        continue;
                    case LogSource.ANDROID_CAMERA /*26*/:
                        int limit = input.pushLimit(input.readRawVarint32());
                        arrayLength = 0;
                        int startPos = input.getPosition();
                        while (input.getBytesUntilLimit() > 0) {
                            switch (input.readInt32()) {
                                case 0:
                                case 1:
                                case 2:
                                case 3:
                                    arrayLength++;
                                    break;
                                default:
                                    break;
                            }
                        }
                        if (arrayLength != 0) {
                            input.rewindToPosition(startPos);
                            if (this.hashMatches == null) {
                                i = 0;
                            } else {
                                i = this.hashMatches.length;
                            }
                            newArray = new int[(i + arrayLength)];
                            if (i != 0) {
                                System.arraycopy(this.hashMatches, 0, newArray, 0, i);
                            }
                            while (input.getBytesUntilLimit() > 0) {
                                value = input.readInt32();
                                switch (value) {
                                    case 0:
                                    case 1:
                                    case 2:
                                    case 3:
                                        int i2 = i + 1;
                                        newArray[i] = value;
                                        i = i2;
                                        break;
                                    default:
                                        break;
                                }
                            }
                            this.hashMatches = newArray;
                        }
                        input.popLimit(limit);
                        continue;
                    case 34:
                        arrayLength = WireFormatNano.getRepeatedFieldArrayLength(input, 34);
                        if (this.filesToUpload == null) {
                            i = 0;
                        } else {
                            i = this.filesToUpload.length;
                        }
                        SystemIntegrityFileToUpload[] newArray2 = new SystemIntegrityFileToUpload[(i + arrayLength)];
                        if (i != 0) {
                            System.arraycopy(this.filesToUpload, 0, newArray2, 0, i);
                        }
                        while (i < newArray2.length - 1) {
                            newArray2[i] = new SystemIntegrityFileToUpload();
                            input.readMessage(newArray2[i]);
                            input.readTag();
                            i++;
                        }
                        newArray2[i] = new SystemIntegrityFileToUpload();
                        input.readMessage(newArray2[i]);
                        this.filesToUpload = newArray2;
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

        public static SystemIntegrityResponse parseFrom(byte[] data) throws InvalidProtocolBufferNanoException {
            return (SystemIntegrityResponse) MessageNano.mergeFrom(new SystemIntegrityResponse(), data);
        }

        public static SystemIntegrityResponse parseFrom(CodedInputByteBufferNano input) throws IOException {
            return new SystemIntegrityResponse().mergeFrom(input);
        }
    }

    public static final class SystemPartitionFileInfo extends ExtendableMessageNano<SystemPartitionFileInfo> {
        private static volatile SystemPartitionFileInfo[] _emptyArray;
        public boolean couldNotCheck;
        public SicFileInfo[] fileInfo;
        public int state;

        public static SystemPartitionFileInfo[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new SystemPartitionFileInfo[0];
                    }
                }
            }
            return _emptyArray;
        }

        public SystemPartitionFileInfo() {
            clear();
        }

        public SystemPartitionFileInfo clear() {
            this.couldNotCheck = false;
            this.fileInfo = SicFileInfo.emptyArray();
            this.state = 0;
            this.unknownFieldData = null;
            this.cachedSize = -1;
            return this;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof SystemPartitionFileInfo)) {
                return false;
            }
            SystemPartitionFileInfo other = (SystemPartitionFileInfo) o;
            if (this.couldNotCheck != other.couldNotCheck || !InternalNano.equals(this.fileInfo, other.fileInfo) || this.state != other.state) {
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
            int hashCode = (((((((getClass().getName().hashCode() + 527) * 31) + (this.couldNotCheck ? 1231 : 1237)) * 31) + InternalNano.hashCode(this.fileInfo)) * 31) + this.state) * 31;
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
                for (SicFileInfo element : this.fileInfo) {
                    if (element != null) {
                        output.writeMessage(2, element);
                    }
                }
            }
            if (this.state != 0) {
                output.writeInt32(3, this.state);
            }
            super.writeTo(output);
        }

        protected int computeSerializedSize() {
            int size = super.computeSerializedSize();
            if (this.couldNotCheck) {
                size += CodedOutputByteBufferNano.computeBoolSize(1, this.couldNotCheck);
            }
            if (this.fileInfo != null && this.fileInfo.length > 0) {
                for (SicFileInfo element : this.fileInfo) {
                    if (element != null) {
                        size += CodedOutputByteBufferNano.computeMessageSize(2, element);
                    }
                }
            }
            if (this.state != 0) {
                return size + CodedOutputByteBufferNano.computeInt32Size(3, this.state);
            }
            return size;
        }

        public SystemPartitionFileInfo mergeFrom(CodedInputByteBufferNano input) throws IOException {
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
                        SicFileInfo[] newArray = new SicFileInfo[(i + arrayLength)];
                        if (i != 0) {
                            System.arraycopy(this.fileInfo, 0, newArray, 0, i);
                        }
                        while (i < newArray.length - 1) {
                            newArray[i] = new SicFileInfo();
                            input.readMessage(newArray[i]);
                            input.readTag();
                            i++;
                        }
                        newArray[i] = new SicFileInfo();
                        input.readMessage(newArray[i]);
                        this.fileInfo = newArray;
                        continue;
                    case 24:
                        int value = input.readInt32();
                        switch (value) {
                            case 0:
                            case 1:
                            case 2:
                            case 3:
                                this.state = value;
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

        public static SystemPartitionFileInfo parseFrom(byte[] data) throws InvalidProtocolBufferNanoException {
            return (SystemPartitionFileInfo) MessageNano.mergeFrom(new SystemPartitionFileInfo(), data);
        }

        public static SystemPartitionFileInfo parseFrom(CodedInputByteBufferNano input) throws IOException {
            return new SystemPartitionFileInfo().mergeFrom(input);
        }
    }

    public static final class SystemProperty extends ExtendableMessageNano<SystemProperty> {
        private static volatile SystemProperty[] _emptyArray;
        public String name;
        public String value;

        public static SystemProperty[] emptyArray() {
            if (_emptyArray == null) {
                synchronized (InternalNano.LAZY_INIT_LOCK) {
                    if (_emptyArray == null) {
                        _emptyArray = new SystemProperty[0];
                    }
                }
            }
            return _emptyArray;
        }

        public SystemProperty() {
            clear();
        }

        public SystemProperty clear() {
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
            if (!(o instanceof SystemProperty)) {
                return false;
            }
            SystemProperty other = (SystemProperty) o;
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

        public SystemProperty mergeFrom(CodedInputByteBufferNano input) throws IOException {
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

        public static SystemProperty parseFrom(byte[] data) throws InvalidProtocolBufferNanoException {
            return (SystemProperty) MessageNano.mergeFrom(new SystemProperty(), data);
        }

        public static SystemProperty parseFrom(CodedInputByteBufferNano input) throws IOException {
            return new SystemProperty().mergeFrom(input);
        }
    }
}
