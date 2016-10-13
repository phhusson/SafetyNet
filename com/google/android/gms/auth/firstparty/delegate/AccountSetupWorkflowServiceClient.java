package com.google.android.gms.auth.firstparty.delegate;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.auth.firstparty.delegate.zza.zza;
import com.google.android.gms.auth.firstparty.shared.BlockingServiceClient;

public class AccountSetupWorkflowServiceClient extends BlockingServiceClient {
    public AccountSetupWorkflowServiceClient(Context context) {
        super(context);
    }

    public PendingIntent getAccountSetupWorkflowIntent(final SetupAccountWorkflowRequest req) {
        return (PendingIntent) exec(new Call<PendingIntent>(this) {
            final /* synthetic */ AccountSetupWorkflowServiceClient zzabN;

            public /* synthetic */ Object exec(IBinder iBinder) throws RemoteException {
                return zzaW(iBinder);
            }

            public PendingIntent zzaW(IBinder iBinder) throws RemoteException {
                return zza.zzaX(iBinder).getAccountSetupWorkflowIntent(req);
            }
        });
    }

    protected Intent getServiceIntent() {
        return new Intent().setAction("com.google.android.gms.auth.setup.workflow.SETUP_WORKFLOW").addCategory("android.intent.category.DEFAULT");
    }
}
