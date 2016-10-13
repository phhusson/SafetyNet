package com.google.android.gms.auth.firstparty.dataservice;

import android.accounts.Account;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.Binder;
import android.os.Bundle;
import android.os.RemoteException;
import android.os.SystemClock;
import android.util.Log;
import com.google.android.gms.auth.AccountChangeEventsRequest;
import com.google.android.gms.auth.AccountChangeEventsResponse;
import com.google.android.gms.auth.firstparty.shared.AccountCredentials;
import com.google.android.gms.common.internal.zzl;
import com.google.android.gms.common.internal.zzx;

public class GoogleAccountDataServiceClient implements GoogleAccountDataClient {
    private final Context mContext;

    private interface zza<R> {
        R zzb(zza com_google_android_gms_auth_firstparty_dataservice_zza) throws RemoteException;
    }

    class C01798 implements zza<AccountRecoveryData> {
        final /* synthetic */ GoogleAccountDataServiceClient zzaaE;

        C01798(GoogleAccountDataServiceClient googleAccountDataServiceClient) {
            this.zzaaE = googleAccountDataServiceClient;
        }

        public /* synthetic */ Object zzb(zza com_google_android_gms_auth_firstparty_dataservice_zza) throws RemoteException {
            return zzf(com_google_android_gms_auth_firstparty_dataservice_zza);
        }

        public AccountRecoveryData zzf(zza com_google_android_gms_auth_firstparty_dataservice_zza) throws RemoteException {
            return com_google_android_gms_auth_firstparty_dataservice_zza.getAccountRecoveryCountryInfo();
        }
    }

    public static class RuntimeInterruptedException extends RuntimeException {
        public RuntimeInterruptedException(InterruptedException e) {
            super(e);
        }
    }

    public static class RuntimeRemoteException extends RuntimeException {
        private final RemoteException zzabc;

        public RuntimeRemoteException(RemoteException e) {
            super(e);
            this.zzabc = e;
        }

        public RemoteException getWrappedException() {
            return this.zzabc;
        }
    }

    public GoogleAccountDataServiceClient(Context context) {
        this.mContext = (Context) zzx.zzD(context);
    }

    private <R> R zza(zza<R> com_google_android_gms_auth_firstparty_dataservice_GoogleAccountDataServiceClient_zza_R) {
        R r = null;
        long clearCallingIdentity = Binder.clearCallingIdentity();
        ServiceConnection com_google_android_gms_common_zza;
        zzl zzav;
        try {
            com_google_android_gms_common_zza = new com.google.android.gms.common.zza();
            zzav = zzl.zzav(this.mContext);
            if (zzav.zza("com.google.android.gms.auth.DATA_PROXY", com_google_android_gms_common_zza, "GoogleAccountDataServiceClient")) {
                r = com_google_android_gms_auth_firstparty_dataservice_GoogleAccountDataServiceClient_zza_R.zzb(com.google.android.gms.auth.firstparty.dataservice.zza.zza.zzaV(com_google_android_gms_common_zza.zzoW()));
                zzav.zzb("com.google.android.gms.auth.DATA_PROXY", com_google_android_gms_common_zza, "GoogleAccountDataServiceClient");
                Binder.restoreCallingIdentity(clearCallingIdentity);
            } else {
                Binder.restoreCallingIdentity(clearCallingIdentity);
            }
        } catch (Throwable e) {
            Log.w("GoogleAccountDataServiceClient", "[GoogleAccountDataServiceClient] Interrupted when getting service.", e);
            zzav.zzb("com.google.android.gms.auth.DATA_PROXY", com_google_android_gms_common_zza, "GoogleAccountDataServiceClient");
            Binder.restoreCallingIdentity(clearCallingIdentity);
        } catch (Throwable e2) {
            Log.w("GoogleAccountDataServiceClient", "[GoogleAccountDataServiceClient] RemoteException when executing call.", e2);
            zzav.zzb("com.google.android.gms.auth.DATA_PROXY", com_google_android_gms_common_zza, "GoogleAccountDataServiceClient");
            Binder.restoreCallingIdentity(clearCallingIdentity);
        } catch (Throwable th) {
            Binder.restoreCallingIdentity(clearCallingIdentity);
        }
        return r;
    }

    public AccountNameCheckResponse checkAccountName(final AccountNameCheckRequest accountCheckRequest) {
        return (AccountNameCheckResponse) zza(new zza<AccountNameCheckResponse>(this) {
            final /* synthetic */ GoogleAccountDataServiceClient zzaaE;

            public /* synthetic */ Object zzb(zza com_google_android_gms_auth_firstparty_dataservice_zza) throws RemoteException {
                return zzi(com_google_android_gms_auth_firstparty_dataservice_zza);
            }

            public AccountNameCheckResponse zzi(zza com_google_android_gms_auth_firstparty_dataservice_zza) throws RemoteException {
                return com_google_android_gms_auth_firstparty_dataservice_zza.checkAccountName(accountCheckRequest);
            }
        });
    }

    public CheckFactoryResetPolicyComplianceResponse checkFactoryResetPolicyCompliance(final CheckFactoryResetPolicyComplianceRequest complianceRequest) {
        return (CheckFactoryResetPolicyComplianceResponse) zza(new zza<CheckFactoryResetPolicyComplianceResponse>(this) {
            final /* synthetic */ GoogleAccountDataServiceClient zzaaE;

            public /* synthetic */ Object zzb(zza com_google_android_gms_auth_firstparty_dataservice_zza) throws RemoteException {
                return zzp(com_google_android_gms_auth_firstparty_dataservice_zza);
            }

            public CheckFactoryResetPolicyComplianceResponse zzp(zza com_google_android_gms_auth_firstparty_dataservice_zza) throws RemoteException {
                return com_google_android_gms_auth_firstparty_dataservice_zza.zza(complianceRequest);
            }
        });
    }

    public PasswordCheckResponse checkPassword(final PasswordCheckRequest request) {
        return (PasswordCheckResponse) zza(new zza<PasswordCheckResponse>(this) {
            final /* synthetic */ GoogleAccountDataServiceClient zzaaE;

            public /* synthetic */ Object zzb(zza com_google_android_gms_auth_firstparty_dataservice_zza) throws RemoteException {
                return zzr(com_google_android_gms_auth_firstparty_dataservice_zza);
            }

            public PasswordCheckResponse zzr(zza com_google_android_gms_auth_firstparty_dataservice_zza) throws RemoteException {
                return com_google_android_gms_auth_firstparty_dataservice_zza.checkPassword(request);
            }
        });
    }

    public CheckRealNameResponse checkRealName(final CheckRealNameRequest request) {
        return (CheckRealNameResponse) zza(new zza<CheckRealNameResponse>(this) {
            final /* synthetic */ GoogleAccountDataServiceClient zzaaE;

            public /* synthetic */ Object zzb(zza com_google_android_gms_auth_firstparty_dataservice_zza) throws RemoteException {
                return zzu(com_google_android_gms_auth_firstparty_dataservice_zza);
            }

            public CheckRealNameResponse zzu(zza com_google_android_gms_auth_firstparty_dataservice_zza) throws RemoteException {
                return com_google_android_gms_auth_firstparty_dataservice_zza.checkRealName(request);
            }
        });
    }

    @Deprecated
    public void clearFactoryResetChallenges() {
        zza(new zza<Void>(this) {
            final /* synthetic */ GoogleAccountDataServiceClient zzaaE;

            {
                this.zzaaE = r1;
            }

            public /* synthetic */ Object zzb(zza com_google_android_gms_auth_firstparty_dataservice_zza) throws RemoteException {
                return zzq(com_google_android_gms_auth_firstparty_dataservice_zza);
            }

            public Void zzq(zza com_google_android_gms_auth_firstparty_dataservice_zza) throws RemoteException {
                com_google_android_gms_auth_firstparty_dataservice_zza.clearFactoryResetChallenges();
                return null;
            }
        });
    }

    public ClearTokenResponse clearToken(final ClearTokenRequest clearTokenRequest) {
        zzx.zzb((Object) clearTokenRequest, (Object) "ClearTokenRequest cannot be null!");
        return (ClearTokenResponse) zza(new zza<ClearTokenResponse>(this) {
            final /* synthetic */ GoogleAccountDataServiceClient zzaaE;

            public /* synthetic */ Object zzb(zza com_google_android_gms_auth_firstparty_dataservice_zza) throws RemoteException {
                return zzd(com_google_android_gms_auth_firstparty_dataservice_zza);
            }

            public ClearTokenResponse zzd(zza com_google_android_gms_auth_firstparty_dataservice_zza) throws RemoteException {
                return com_google_android_gms_auth_firstparty_dataservice_zza.clearToken(clearTokenRequest);
            }
        });
    }

    public boolean clearWorkAccountAppWhitelist() {
        return ((Boolean) zza(new zza<Boolean>(this) {
            final /* synthetic */ GoogleAccountDataServiceClient zzaaE;

            {
                this.zzaaE = r1;
            }

            public /* synthetic */ Object zzb(zza com_google_android_gms_auth_firstparty_dataservice_zza) throws RemoteException {
                return zzk(com_google_android_gms_auth_firstparty_dataservice_zza);
            }

            public Boolean zzk(zza com_google_android_gms_auth_firstparty_dataservice_zza) throws RemoteException {
                return Boolean.valueOf(com_google_android_gms_auth_firstparty_dataservice_zza.clearWorkAccountAppWhitelist());
            }
        })).booleanValue();
    }

    public TokenResponse confirmCredentials(final ConfirmCredentialsRequest request) {
        return (TokenResponse) zza(new zza<TokenResponse>(this) {
            final /* synthetic */ GoogleAccountDataServiceClient zzaaE;

            public /* synthetic */ Object zzb(zza com_google_android_gms_auth_firstparty_dataservice_zza) throws RemoteException {
                return zzc(com_google_android_gms_auth_firstparty_dataservice_zza);
            }

            public TokenResponse zzc(zza com_google_android_gms_auth_firstparty_dataservice_zza) throws RemoteException {
                return com_google_android_gms_auth_firstparty_dataservice_zza.confirmCredentials(request);
            }
        });
    }

    public TokenResponse createAccount(final GoogleAccountSetupRequest signUpRequest) {
        return (TokenResponse) zza(new zza<TokenResponse>(this) {
            final /* synthetic */ GoogleAccountDataServiceClient zzaaE;

            public /* synthetic */ Object zzb(zza com_google_android_gms_auth_firstparty_dataservice_zza) throws RemoteException {
                return zzc(com_google_android_gms_auth_firstparty_dataservice_zza);
            }

            public TokenResponse zzc(zza com_google_android_gms_auth_firstparty_dataservice_zza) throws RemoteException {
                return com_google_android_gms_auth_firstparty_dataservice_zza.createAccount(signUpRequest);
            }
        });
    }

    public TokenResponse createPlusProfile(final GoogleAccountSetupRequest signUpRequest) {
        return (TokenResponse) zza(new zza<TokenResponse>(this) {
            final /* synthetic */ GoogleAccountDataServiceClient zzaaE;

            public /* synthetic */ Object zzb(zza com_google_android_gms_auth_firstparty_dataservice_zza) throws RemoteException {
                return zzc(com_google_android_gms_auth_firstparty_dataservice_zza);
            }

            public TokenResponse zzc(zza com_google_android_gms_auth_firstparty_dataservice_zza) throws RemoteException {
                return com_google_android_gms_auth_firstparty_dataservice_zza.createPlusProfile(signUpRequest);
            }
        });
    }

    public AccountChangeEventsResponse getAccountChangeEvents(final AccountChangeEventsRequest request) {
        zzx.zzD(request);
        return (AccountChangeEventsResponse) zza(new zza<AccountChangeEventsResponse>(this) {
            final /* synthetic */ GoogleAccountDataServiceClient zzaaE;

            public /* synthetic */ Object zzb(zza com_google_android_gms_auth_firstparty_dataservice_zza) throws RemoteException {
                return zzn(com_google_android_gms_auth_firstparty_dataservice_zza);
            }

            public AccountChangeEventsResponse zzn(zza com_google_android_gms_auth_firstparty_dataservice_zza) throws RemoteException {
                return com_google_android_gms_auth_firstparty_dataservice_zza.getAccountChangeEvents(request);
            }
        });
    }

    @Deprecated
    public GoogleAccountData getAccountData(String accountName) {
        return getGoogleAccountData(new Account(accountName, "com.google"));
    }

    public Bundle getAccountExportData(final String accountName) {
        return (Bundle) zza(new zza<Bundle>(this) {
            final /* synthetic */ GoogleAccountDataServiceClient zzaaE;

            public /* synthetic */ Object zzb(zza com_google_android_gms_auth_firstparty_dataservice_zza) throws RemoteException {
                return zzj(com_google_android_gms_auth_firstparty_dataservice_zza);
            }

            public Bundle zzj(zza com_google_android_gms_auth_firstparty_dataservice_zza) throws RemoteException {
                return com_google_android_gms_auth_firstparty_dataservice_zza.getAccountExportData(accountName);
            }
        });
    }

    public String getAccountId(final String accountName) {
        return (String) zza(new zza<String>(this) {
            final /* synthetic */ GoogleAccountDataServiceClient zzaaE;

            public /* synthetic */ Object zzb(zza com_google_android_gms_auth_firstparty_dataservice_zza) throws RemoteException {
                return zzw(com_google_android_gms_auth_firstparty_dataservice_zza);
            }

            public String zzw(zza com_google_android_gms_auth_firstparty_dataservice_zza) throws RemoteException {
                return com_google_android_gms_auth_firstparty_dataservice_zza.getAccountId(accountName);
            }
        });
    }

    public AccountRecoveryData getAccountRecoveryCountryInfo() {
        return (AccountRecoveryData) zza(new C01798(this));
    }

    public AccountRecoveryData getAccountRecoveryData(final AccountRecoveryDataRequest request) {
        return (AccountRecoveryData) zza(new zza<AccountRecoveryData>(this) {
            final /* synthetic */ GoogleAccountDataServiceClient zzaaE;

            public /* synthetic */ Object zzb(zza com_google_android_gms_auth_firstparty_dataservice_zza) throws RemoteException {
                return zzf(com_google_android_gms_auth_firstparty_dataservice_zza);
            }

            public AccountRecoveryData zzf(zza com_google_android_gms_auth_firstparty_dataservice_zza) throws RemoteException {
                return com_google_android_gms_auth_firstparty_dataservice_zza.getAccountRecoveryData(request);
            }
        });
    }

    public AccountRecoveryGuidance getAccountRecoveryGuidance(final AccountRecoveryGuidanceRequest request) {
        return (AccountRecoveryGuidance) zza(new zza<AccountRecoveryGuidance>(this) {
            final /* synthetic */ GoogleAccountDataServiceClient zzaaE;

            public /* synthetic */ Object zzb(zza com_google_android_gms_auth_firstparty_dataservice_zza) throws RemoteException {
                return zzg(com_google_android_gms_auth_firstparty_dataservice_zza);
            }

            public AccountRecoveryGuidance zzg(zza com_google_android_gms_auth_firstparty_dataservice_zza) throws RemoteException {
                return com_google_android_gms_auth_firstparty_dataservice_zza.getAccountRecoveryGuidance(request);
            }
        });
    }

    public GetAndAdvanceOtpCounterResponse getAndAdvanceOtpCounter(final String accountName) {
        return (GetAndAdvanceOtpCounterResponse) zza(new zza<GetAndAdvanceOtpCounterResponse>(this) {
            final /* synthetic */ GoogleAccountDataServiceClient zzaaE;

            public /* synthetic */ Object zzb(zza com_google_android_gms_auth_firstparty_dataservice_zza) throws RemoteException {
                return zzt(com_google_android_gms_auth_firstparty_dataservice_zza);
            }

            public GetAndAdvanceOtpCounterResponse zzt(zza com_google_android_gms_auth_firstparty_dataservice_zza) throws RemoteException {
                return com_google_android_gms_auth_firstparty_dataservice_zza.getAndAdvanceOtpCounter(accountName);
            }
        });
    }

    public GoogleAccountData getGoogleAccountData(final Account account) {
        return (GoogleAccountData) zza(new zza<GoogleAccountData>(this) {
            final /* synthetic */ GoogleAccountDataServiceClient zzaaE;

            public GoogleAccountData zza(zza com_google_android_gms_auth_firstparty_dataservice_zza) throws RemoteException {
                return com_google_android_gms_auth_firstparty_dataservice_zza.getGoogleAccountData(account);
            }

            public /* synthetic */ Object zzb(zza com_google_android_gms_auth_firstparty_dataservice_zza) throws RemoteException {
                return zza(com_google_android_gms_auth_firstparty_dataservice_zza);
            }
        });
    }

    public String getGoogleAccountId(final Account account) {
        return (String) zza(new zza<String>(this) {
            final /* synthetic */ GoogleAccountDataServiceClient zzaaE;

            public /* synthetic */ Object zzb(zza com_google_android_gms_auth_firstparty_dataservice_zza) throws RemoteException {
                return zzw(com_google_android_gms_auth_firstparty_dataservice_zza);
            }

            public String zzw(zza com_google_android_gms_auth_firstparty_dataservice_zza) throws RemoteException {
                return com_google_android_gms_auth_firstparty_dataservice_zza.getGoogleAccountId(account);
            }
        });
    }

    public GplusInfoResponse getGplusInfo(final GplusInfoRequest request) {
        return (GplusInfoResponse) zza(new zza<GplusInfoResponse>(this) {
            final /* synthetic */ GoogleAccountDataServiceClient zzaaE;

            public /* synthetic */ Object zzb(zza com_google_android_gms_auth_firstparty_dataservice_zza) throws RemoteException {
                return zzv(com_google_android_gms_auth_firstparty_dataservice_zza);
            }

            public GplusInfoResponse zzv(zza com_google_android_gms_auth_firstparty_dataservice_zza) throws RemoteException {
                return com_google_android_gms_auth_firstparty_dataservice_zza.getGplusInfo(request);
            }
        });
    }

    public OtpResponse getOtp(final OtpRequest request) {
        return (OtpResponse) zza(new zza<OtpResponse>(this) {
            final /* synthetic */ GoogleAccountDataServiceClient zzaaE;

            public /* synthetic */ Object zzb(zza com_google_android_gms_auth_firstparty_dataservice_zza) throws RemoteException {
                return zzo(com_google_android_gms_auth_firstparty_dataservice_zza);
            }

            public OtpResponse zzo(zza com_google_android_gms_auth_firstparty_dataservice_zza) throws RemoteException {
                return com_google_android_gms_auth_firstparty_dataservice_zza.getOtp(request);
            }
        });
    }

    public ReauthSettingsResponse getReauthSettings(final ReauthSettingsRequest request) {
        zzx.zzD(request);
        request.zzbQ(this.mContext.getPackageName());
        return (ReauthSettingsResponse) zza(new zza<ReauthSettingsResponse>(this) {
            final /* synthetic */ GoogleAccountDataServiceClient zzaaE;

            public /* synthetic */ Object zzb(zza com_google_android_gms_auth_firstparty_dataservice_zza) throws RemoteException {
                return zzl(com_google_android_gms_auth_firstparty_dataservice_zza);
            }

            public ReauthSettingsResponse zzl(zza com_google_android_gms_auth_firstparty_dataservice_zza) throws RemoteException {
                return com_google_android_gms_auth_firstparty_dataservice_zza.getReauthSettings(request);
            }
        });
    }

    public TokenResponse getToken(final TokenRequest tokenRequest) {
        zzx.zzb((Object) tokenRequest, (Object) "TokenRequest cannot be null!");
        Bundle options = tokenRequest.getOptions();
        options.putLong("gads_service_connection_start_time_millis", SystemClock.elapsedRealtime());
        tokenRequest.setOptions(options);
        return (TokenResponse) zza(new zza<TokenResponse>(this) {
            final /* synthetic */ GoogleAccountDataServiceClient zzaaE;

            public /* synthetic */ Object zzb(zza com_google_android_gms_auth_firstparty_dataservice_zza) throws RemoteException {
                return zzc(com_google_android_gms_auth_firstparty_dataservice_zza);
            }

            public TokenResponse zzc(zza com_google_android_gms_auth_firstparty_dataservice_zza) throws RemoteException {
                return com_google_android_gms_auth_firstparty_dataservice_zza.getToken(tokenRequest);
            }
        });
    }

    @Deprecated
    public WebSetupConfig getWebSetupConfig(WebSetupConfigRequest request) {
        throw new UnsupportedOperationException();
    }

    public boolean installAccountFromExportData(final String accountName, final Bundle exportData) {
        return ((Boolean) zza(new zza<Boolean>(this) {
            final /* synthetic */ GoogleAccountDataServiceClient zzaaE;

            public /* synthetic */ Object zzb(zza com_google_android_gms_auth_firstparty_dataservice_zza) throws RemoteException {
                return zzk(com_google_android_gms_auth_firstparty_dataservice_zza);
            }

            public Boolean zzk(zza com_google_android_gms_auth_firstparty_dataservice_zza) throws RemoteException {
                return Boolean.valueOf(com_google_android_gms_auth_firstparty_dataservice_zza.installAccountFromExportData(accountName, exportData));
            }
        })).booleanValue();
    }

    public AccountRemovalResponse removeAccount(final AccountRemovalRequest request) {
        return (AccountRemovalResponse) zza(new zza<AccountRemovalResponse>(this) {
            final /* synthetic */ GoogleAccountDataServiceClient zzaaE;

            public /* synthetic */ Object zzb(zza com_google_android_gms_auth_firstparty_dataservice_zza) throws RemoteException {
                return zze(com_google_android_gms_auth_firstparty_dataservice_zza);
            }

            public AccountRemovalResponse zze(zza com_google_android_gms_auth_firstparty_dataservice_zza) throws RemoteException {
                return com_google_android_gms_auth_firstparty_dataservice_zza.removeAccount(request);
            }
        });
    }

    public boolean setWorkAccountAppWhitelistFingerprint(final String packageName, final String signatureFingerprint) {
        zzx.zzi(packageName, "Package name must not be empty");
        return ((Boolean) zza(new zza<Boolean>(this) {
            final /* synthetic */ GoogleAccountDataServiceClient zzaaE;

            public /* synthetic */ Object zzb(zza com_google_android_gms_auth_firstparty_dataservice_zza) throws RemoteException {
                return zzk(com_google_android_gms_auth_firstparty_dataservice_zza);
            }

            public Boolean zzk(zza com_google_android_gms_auth_firstparty_dataservice_zza) throws RemoteException {
                return Boolean.valueOf(com_google_android_gms_auth_firstparty_dataservice_zza.setWorkAccountAppWhitelistFingerprint(packageName, signatureFingerprint));
            }
        })).booleanValue();
    }

    public TokenResponse signIn(final AccountSignInRequest request) {
        return (TokenResponse) zza(new zza<TokenResponse>(this) {
            final /* synthetic */ GoogleAccountDataServiceClient zzaaE;

            public /* synthetic */ Object zzb(zza com_google_android_gms_auth_firstparty_dataservice_zza) throws RemoteException {
                return zzc(com_google_android_gms_auth_firstparty_dataservice_zza);
            }

            public TokenResponse zzc(zza com_google_android_gms_auth_firstparty_dataservice_zza) throws RemoteException {
                return com_google_android_gms_auth_firstparty_dataservice_zza.signIn(request);
            }
        });
    }

    public AccountRecoveryUpdateResult updateAccountRecoveryData(final AccountRecoveryUpdateRequest request) {
        return (AccountRecoveryUpdateResult) zza(new zza<AccountRecoveryUpdateResult>(this) {
            final /* synthetic */ GoogleAccountDataServiceClient zzaaE;

            public /* synthetic */ Object zzb(zza com_google_android_gms_auth_firstparty_dataservice_zza) throws RemoteException {
                return zzh(com_google_android_gms_auth_firstparty_dataservice_zza);
            }

            public AccountRecoveryUpdateResult zzh(zza com_google_android_gms_auth_firstparty_dataservice_zza) throws RemoteException {
                return com_google_android_gms_auth_firstparty_dataservice_zza.updateAccountRecoveryData(request);
            }
        });
    }

    public TokenResponse updateCredentials(final UpdateCredentialsRequest request) {
        return (TokenResponse) zza(new zza<TokenResponse>(this) {
            final /* synthetic */ GoogleAccountDataServiceClient zzaaE;

            public /* synthetic */ Object zzb(zza com_google_android_gms_auth_firstparty_dataservice_zza) throws RemoteException {
                return zzc(com_google_android_gms_auth_firstparty_dataservice_zza);
            }

            public TokenResponse zzc(zza com_google_android_gms_auth_firstparty_dataservice_zza) throws RemoteException {
                return com_google_android_gms_auth_firstparty_dataservice_zza.updateCredentials(request);
            }
        });
    }

    public ValidateAccountCredentialsResponse validateAccountCredentials(final AccountCredentials accountCreds) {
        return (ValidateAccountCredentialsResponse) zza(new zza<ValidateAccountCredentialsResponse>(this) {
            final /* synthetic */ GoogleAccountDataServiceClient zzaaE;

            public /* synthetic */ Object zzb(zza com_google_android_gms_auth_firstparty_dataservice_zza) throws RemoteException {
                return zzs(com_google_android_gms_auth_firstparty_dataservice_zza);
            }

            public ValidateAccountCredentialsResponse zzs(zza com_google_android_gms_auth_firstparty_dataservice_zza) throws RemoteException {
                return com_google_android_gms_auth_firstparty_dataservice_zza.validateAccountCredentials(accountCreds);
            }
        });
    }

    public VerifyPinResponse verifyPin(final VerifyPinRequest request) {
        zzx.zzD(request);
        request.zzbQ(this.mContext.getPackageName());
        return (VerifyPinResponse) zza(new zza<VerifyPinResponse>(this) {
            final /* synthetic */ GoogleAccountDataServiceClient zzaaE;

            public /* synthetic */ Object zzb(zza com_google_android_gms_auth_firstparty_dataservice_zza) throws RemoteException {
                return zzm(com_google_android_gms_auth_firstparty_dataservice_zza);
            }

            public VerifyPinResponse zzm(zza com_google_android_gms_auth_firstparty_dataservice_zza) throws RemoteException {
                return com_google_android_gms_auth_firstparty_dataservice_zza.verifyPin(request);
            }
        });
    }
}
