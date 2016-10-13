package com.google.android.gms.internal;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class zzaih<M extends zzaig<M>, T> {
    public final int tag;
    protected final int type;
    protected final Class<T> zzcqp;
    protected final boolean zzcqq;

    private zzaih(int i, Class<T> cls, int i2, boolean z) {
        this.type = i;
        this.zzcqp = cls;
        this.tag = i2;
        this.zzcqq = z;
    }

    public static <M extends zzaig<M>, T extends zzain> zzaih<M, T> zza(int i, Class<T> cls, long j) {
        return new zzaih(i, cls, (int) j, false);
    }

    private T zzab(List<zzaip> list) {
        int i;
        int i2 = 0;
        List arrayList = new ArrayList();
        for (i = 0; i < list.size(); i++) {
            zzaip com_google_android_gms_internal_zzaip = (zzaip) list.get(i);
            if (com_google_android_gms_internal_zzaip.zzcqz.length != 0) {
                zza(com_google_android_gms_internal_zzaip, arrayList);
            }
        }
        i = arrayList.size();
        if (i == 0) {
            return null;
        }
        T cast = this.zzcqp.cast(Array.newInstance(this.zzcqp.getComponentType(), i));
        while (i2 < i) {
            Array.set(cast, i2, arrayList.get(i2));
            i2++;
        }
        return cast;
    }

    private T zzac(List<zzaip> list) {
        if (list.isEmpty()) {
            return null;
        }
        return this.zzcqp.cast(zzaE(zzaie.zzV(((zzaip) list.get(list.size() - 1)).zzcqz)));
    }

    protected void zza(zzaip com_google_android_gms_internal_zzaip, List<Object> list) {
        list.add(zzaE(zzaie.zzV(com_google_android_gms_internal_zzaip.zzcqz)));
    }

    void zza(Object obj, zzaif com_google_android_gms_internal_zzaif) throws IOException {
        if (this.zzcqq) {
            zzc(obj, com_google_android_gms_internal_zzaif);
        } else {
            zzb(obj, com_google_android_gms_internal_zzaif);
        }
    }

    protected Object zzaE(zzaie com_google_android_gms_internal_zzaie) {
        Class componentType = this.zzcqq ? this.zzcqp.getComponentType() : this.zzcqp;
        try {
            zzain com_google_android_gms_internal_zzain;
            switch (this.type) {
                case 10:
                    com_google_android_gms_internal_zzain = (zzain) componentType.newInstance();
                    com_google_android_gms_internal_zzaie.zza(com_google_android_gms_internal_zzain, zzaiq.zzts(this.tag));
                    return com_google_android_gms_internal_zzain;
                case 11:
                    com_google_android_gms_internal_zzain = (zzain) componentType.newInstance();
                    com_google_android_gms_internal_zzaie.zza(com_google_android_gms_internal_zzain);
                    return com_google_android_gms_internal_zzain;
                default:
                    throw new IllegalArgumentException("Unknown type " + this.type);
            }
        } catch (Throwable e) {
            throw new IllegalArgumentException("Error creating instance of class " + componentType, e);
        } catch (Throwable e2) {
            throw new IllegalArgumentException("Error creating instance of class " + componentType, e2);
        } catch (Throwable e22) {
            throw new IllegalArgumentException("Error reading extension field", e22);
        }
    }

    final T zzaa(List<zzaip> list) {
        return list == null ? null : this.zzcqq ? zzab(list) : zzac(list);
    }

    int zzan(Object obj) {
        return this.zzcqq ? zzao(obj) : zzap(obj);
    }

    protected int zzao(Object obj) {
        int i = 0;
        int length = Array.getLength(obj);
        for (int i2 = 0; i2 < length; i2++) {
            if (Array.get(obj, i2) != null) {
                i += zzap(Array.get(obj, i2));
            }
        }
        return i;
    }

    protected int zzap(Object obj) {
        int zzts = zzaiq.zzts(this.tag);
        switch (this.type) {
            case 10:
                return zzaif.zzb(zzts, (zzain) obj);
            case 11:
                return zzaif.zzc(zzts, (zzain) obj);
            default:
                throw new IllegalArgumentException("Unknown type " + this.type);
        }
    }

    protected void zzb(Object obj, zzaif com_google_android_gms_internal_zzaif) {
        try {
            com_google_android_gms_internal_zzaif.zztj(this.tag);
            switch (this.type) {
                case 10:
                    zzain com_google_android_gms_internal_zzain = (zzain) obj;
                    int zzts = zzaiq.zzts(this.tag);
                    com_google_android_gms_internal_zzaif.zzb(com_google_android_gms_internal_zzain);
                    com_google_android_gms_internal_zzaif.zzV(zzts, 4);
                    return;
                case 11:
                    com_google_android_gms_internal_zzaif.zzc((zzain) obj);
                    return;
                default:
                    throw new IllegalArgumentException("Unknown type " + this.type);
            }
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
        throw new IllegalStateException(e);
    }

    protected void zzc(Object obj, zzaif com_google_android_gms_internal_zzaif) {
        int length = Array.getLength(obj);
        for (int i = 0; i < length; i++) {
            Object obj2 = Array.get(obj, i);
            if (obj2 != null) {
                zzb(obj2, com_google_android_gms_internal_zzaif);
            }
        }
    }
}
