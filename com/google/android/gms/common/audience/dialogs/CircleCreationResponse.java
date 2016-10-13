package com.google.android.gms.common.audience.dialogs;

import android.content.Intent;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.common.people.data.AudienceMember;

public class CircleCreationResponse {
    public static final int STATUS_CODE_ERROR = 2;
    public static final int STATUS_CODE_NOT_INTENDED = 3;
    public static final int STATUS_CODE_SUCCESS = 1;
    private final AudienceMember zzatk;
    private final String zzatl;
    private final int zzatm;
    private final int zzatn;

    public CircleCreationResponse(int createCircleStatusCode, AudienceMember circle, int addPersonStatusCode, String qualifiedId) {
        this.zzatm = createCircleStatusCode;
        this.zzatk = circle;
        this.zzatn = addPersonStatusCode;
        this.zzatl = qualifiedId;
        zzqm();
    }

    public CircleCreationResponse(Intent intent) {
        this.zzatm = intent.getIntExtra("com.google.android.gms.plus.audience.EXTRA_CREATE_CIRCLE_STATUS_CODE", 0);
        this.zzatk = (AudienceMember) intent.getParcelableExtra("com.google.android.gms.plus.audience.EXTRA_CIRCLE");
        this.zzatn = intent.getIntExtra("com.google.android.gms.plus.audience.EXTRA_ADD_PERSON_STATUS_CODE", 0);
        this.zzatl = intent.getStringExtra("com.google.android.gms.plus.audience.EXTRA_QUALIFIED_ID");
        zzqm();
    }

    private void zzqm() {
        zzx.zza(this.zzatm, (Object) "Invalid create circle status code.");
        zzx.zza(this.zzatn, (Object) "Invalid add person status code.");
        if (this.zzatm == 1) {
            zzx.zzb(this.zzatk.getCircleId(), (Object) "Must provide a circle with circle id.");
            zzx.zzb(this.zzatk.getDisplayName(), (Object) "Must provide a circle with display name.");
        }
        if (this.zzatn == 1) {
            zzx.zzb(this.zzatl, (Object) "Must provide qualified id.");
        }
    }

    public Intent convertToIntent() {
        Intent intent = new Intent();
        intent.putExtra("com.google.android.gms.plus.audience.EXTRA_CREATE_CIRCLE_STATUS_CODE", this.zzatm);
        intent.putExtra("com.google.android.gms.plus.audience.EXTRA_CIRCLE", this.zzatk);
        intent.putExtra("com.google.android.gms.plus.audience.EXTRA_ADD_PERSON_STATUS_CODE", this.zzatn);
        intent.putExtra("com.google.android.gms.plus.audience.EXTRA_QUALIFIED_ID", this.zzatl);
        return intent;
    }

    public int getAddPersonStatusCode() {
        return this.zzatn;
    }

    public AudienceMember getCircle() {
        return this.zzatk;
    }

    public int getCreateCircleStatusCode() {
        return this.zzatm;
    }

    public String getQualifiedId() {
        return this.zzatl;
    }
}
