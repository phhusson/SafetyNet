package com.google.android.gms.common;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout;
import com.google.android.gms.base.C0187R;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.common.internal.zzac;
import com.google.android.gms.dynamic.zzg.zza;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public final class SignInButton extends FrameLayout implements OnClickListener {
    public static final int COLOR_AUTO = 2;
    public static final int COLOR_DARK = 0;
    public static final int COLOR_LIGHT = 1;
    public static final int SIZE_ICON_ONLY = 2;
    public static final int SIZE_STANDARD = 0;
    public static final int SIZE_WIDE = 1;
    private int mColor;
    private int mSize;
    private Scope[] zzaqd;
    private View zzaqe;
    private OnClickListener zzaqf;

    @Retention(RetentionPolicy.SOURCE)
    public @interface ButtonSize {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface ColorScheme {
    }

    public SignInButton(Context context) {
        this(context, null);
    }

    public SignInButton(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SignInButton(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.zzaqf = null;
        zza(context, attrs);
        setStyle(this.mSize, this.mColor, this.zzaqd);
    }

    private static Button zza(Context context, int i, int i2, Scope[] scopeArr) {
        Button com_google_android_gms_common_internal_zzac = new zzac(context);
        com_google_android_gms_common_internal_zzac.zza(context.getResources(), i, i2, scopeArr);
        return com_google_android_gms_common_internal_zzac;
    }

    private void zza(Context context, AttributeSet attributeSet) {
        int i = 0;
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, C0187R.styleable.SignInButton, 0, 0);
        try {
            this.mSize = obtainStyledAttributes.getInt(C0187R.styleable.SignInButton_buttonSize, 0);
            this.mColor = obtainStyledAttributes.getInt(C0187R.styleable.SignInButton_colorScheme, 2);
            String string = obtainStyledAttributes.getString(C0187R.styleable.SignInButton_scopeUris);
            if (string == null) {
                this.zzaqd = null;
            } else {
                String[] split = string.trim().split("\\s+");
                this.zzaqd = new Scope[split.length];
                while (i < split.length) {
                    this.zzaqd[i] = new Scope(split[i].toString());
                    i++;
                }
            }
            obtainStyledAttributes.recycle();
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
        }
    }

    private void zzar(Context context) {
        if (this.zzaqe != null) {
            removeView(this.zzaqe);
        }
        try {
            this.zzaqe = zzab.zzb(context, this.mSize, this.mColor, this.zzaqd);
        } catch (zza e) {
            Log.w("SignInButton", "Sign in button not found, using placeholder instead");
            this.zzaqe = zza(context, this.mSize, this.mColor, this.zzaqd);
        }
        addView(this.zzaqe);
        this.zzaqe.setEnabled(isEnabled());
        this.zzaqe.setOnClickListener(this);
    }

    public void onClick(View view) {
        if (this.zzaqf != null && view == this.zzaqe) {
            this.zzaqf.onClick(this);
        }
    }

    public void setColorScheme(int colorScheme) {
        setStyle(this.mSize, colorScheme, this.zzaqd);
    }

    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);
        this.zzaqe.setEnabled(enabled);
    }

    public void setOnClickListener(OnClickListener listener) {
        this.zzaqf = listener;
        if (this.zzaqe != null) {
            this.zzaqe.setOnClickListener(this);
        }
    }

    public void setScopes(Scope[] scopes) {
        setStyle(this.mSize, this.mColor, scopes);
    }

    public void setSize(int buttonSize) {
        setStyle(buttonSize, this.mColor, this.zzaqd);
    }

    public void setStyle(int buttonSize, int colorScheme) {
        setStyle(buttonSize, colorScheme, this.zzaqd);
    }

    public void setStyle(int buttonSize, int colorScheme, Scope[] scopes) {
        this.mSize = buttonSize;
        this.mColor = colorScheme;
        this.zzaqd = scopes;
        zzar(getContext());
    }
}
