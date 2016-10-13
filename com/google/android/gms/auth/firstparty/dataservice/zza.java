package com.google.android.gms.auth.firstparty.dataservice;

import android.accounts.Account;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import android.support.v4.view.MotionEventCompat;
import com.google.android.gms.auth.AccountChangeEventsRequest;
import com.google.android.gms.auth.AccountChangeEventsResponse;
import com.google.android.gms.auth.firstparty.shared.AccountCredentials;
import com.google.android.gms.playlog.PlayLogger.LogSource;

public interface zza extends IInterface {

    public static abstract class zza extends Binder implements zza {

        private static class zza implements zza {
            private IBinder zzoz;

            zza(IBinder iBinder) {
                this.zzoz = iBinder;
            }

            public IBinder asBinder() {
                return this.zzoz;
            }

            public AccountNameCheckResponse checkAccountName(AccountNameCheckRequest request) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.auth.firstparty.dataservice.IGoogleAccountDataService");
                    if (request != null) {
                        obtain.writeInt(1);
                        request.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoz.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    AccountNameCheckResponse createFromParcel = obtain2.readInt() != 0 ? AccountNameCheckResponse.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return createFromParcel;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public PasswordCheckResponse checkPassword(PasswordCheckRequest request) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.auth.firstparty.dataservice.IGoogleAccountDataService");
                    if (request != null) {
                        obtain.writeInt(1);
                        request.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoz.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    PasswordCheckResponse createFromParcel = obtain2.readInt() != 0 ? PasswordCheckResponse.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return createFromParcel;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public CheckRealNameResponse checkRealName(CheckRealNameRequest request) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.auth.firstparty.dataservice.IGoogleAccountDataService");
                    if (request != null) {
                        obtain.writeInt(1);
                        request.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoz.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                    CheckRealNameResponse createFromParcel = obtain2.readInt() != 0 ? CheckRealNameResponse.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return createFromParcel;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void clearFactoryResetChallenges() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.auth.firstparty.dataservice.IGoogleAccountDataService");
                    this.zzoz.transact(29, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public ClearTokenResponse clearToken(ClearTokenRequest request) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.auth.firstparty.dataservice.IGoogleAccountDataService");
                    if (request != null) {
                        obtain.writeInt(1);
                        request.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoz.transact(19, obtain, obtain2, 0);
                    obtain2.readException();
                    ClearTokenResponse createFromParcel = obtain2.readInt() != 0 ? ClearTokenResponse.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return createFromParcel;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean clearWorkAccountAppWhitelist() throws RemoteException {
                boolean z = false;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.auth.firstparty.dataservice.IGoogleAccountDataService");
                    this.zzoz.transact(35, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return z;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public TokenResponse confirmCredentials(ConfirmCredentialsRequest request) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.auth.firstparty.dataservice.IGoogleAccountDataService");
                    if (request != null) {
                        obtain.writeInt(1);
                        request.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoz.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                    TokenResponse createFromParcel = obtain2.readInt() != 0 ? TokenResponse.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return createFromParcel;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public TokenResponse createAccount(GoogleAccountSetupRequest request) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.auth.firstparty.dataservice.IGoogleAccountDataService");
                    if (request != null) {
                        obtain.writeInt(1);
                        request.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoz.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                    TokenResponse createFromParcel = obtain2.readInt() != 0 ? TokenResponse.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return createFromParcel;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public TokenResponse createPlusProfile(GoogleAccountSetupRequest request) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.auth.firstparty.dataservice.IGoogleAccountDataService");
                    if (request != null) {
                        obtain.writeInt(1);
                        request.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoz.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                    TokenResponse createFromParcel = obtain2.readInt() != 0 ? TokenResponse.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return createFromParcel;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public AccountChangeEventsResponse getAccountChangeEvents(AccountChangeEventsRequest request) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.auth.firstparty.dataservice.IGoogleAccountDataService");
                    if (request != null) {
                        obtain.writeInt(1);
                        request.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoz.transact(23, obtain, obtain2, 0);
                    obtain2.readException();
                    AccountChangeEventsResponse accountChangeEventsResponse = obtain2.readInt() != 0 ? (AccountChangeEventsResponse) AccountChangeEventsResponse.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return accountChangeEventsResponse;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public GoogleAccountData getAccountData(String accountName) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.auth.firstparty.dataservice.IGoogleAccountDataService");
                    obtain.writeString(accountName);
                    this.zzoz.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    GoogleAccountData createFromParcel = obtain2.readInt() != 0 ? GoogleAccountData.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return createFromParcel;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public Bundle getAccountExportData(String accountName) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.auth.firstparty.dataservice.IGoogleAccountDataService");
                    obtain.writeString(accountName);
                    this.zzoz.transact(16, obtain, obtain2, 0);
                    obtain2.readException();
                    Bundle bundle = obtain2.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return bundle;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String getAccountId(String accountName) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.auth.firstparty.dataservice.IGoogleAccountDataService");
                    obtain.writeString(accountName);
                    this.zzoz.transact(25, obtain, obtain2, 0);
                    obtain2.readException();
                    String readString = obtain2.readString();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public AccountRecoveryData getAccountRecoveryCountryInfo() throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.auth.firstparty.dataservice.IGoogleAccountDataService");
                    this.zzoz.transact(12, obtain, obtain2, 0);
                    obtain2.readException();
                    AccountRecoveryData createFromParcel = obtain2.readInt() != 0 ? AccountRecoveryData.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return createFromParcel;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public AccountRecoveryData getAccountRecoveryData(AccountRecoveryDataRequest request) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.auth.firstparty.dataservice.IGoogleAccountDataService");
                    if (request != null) {
                        obtain.writeInt(1);
                        request.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoz.transact(13, obtain, obtain2, 0);
                    obtain2.readException();
                    AccountRecoveryData createFromParcel = obtain2.readInt() != 0 ? AccountRecoveryData.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return createFromParcel;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public AccountRecoveryGuidance getAccountRecoveryGuidance(AccountRecoveryGuidanceRequest request) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.auth.firstparty.dataservice.IGoogleAccountDataService");
                    if (request != null) {
                        obtain.writeInt(1);
                        request.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoz.transact(15, obtain, obtain2, 0);
                    obtain2.readException();
                    AccountRecoveryGuidance createFromParcel = obtain2.readInt() != 0 ? AccountRecoveryGuidance.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return createFromParcel;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public GetAndAdvanceOtpCounterResponse getAndAdvanceOtpCounter(String accountName) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.auth.firstparty.dataservice.IGoogleAccountDataService");
                    obtain.writeString(accountName);
                    this.zzoz.transact(37, obtain, obtain2, 0);
                    obtain2.readException();
                    GetAndAdvanceOtpCounterResponse createFromParcel = obtain2.readInt() != 0 ? GetAndAdvanceOtpCounterResponse.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return createFromParcel;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public GoogleAccountData getGoogleAccountData(Account account) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.auth.firstparty.dataservice.IGoogleAccountDataService");
                    if (account != null) {
                        obtain.writeInt(1);
                        account.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoz.transact(30, obtain, obtain2, 0);
                    obtain2.readException();
                    GoogleAccountData createFromParcel = obtain2.readInt() != 0 ? GoogleAccountData.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return createFromParcel;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String getGoogleAccountId(Account account) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.auth.firstparty.dataservice.IGoogleAccountDataService");
                    if (account != null) {
                        obtain.writeInt(1);
                        account.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoz.transact(31, obtain, obtain2, 0);
                    obtain2.readException();
                    String readString = obtain2.readString();
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public GplusInfoResponse getGplusInfo(GplusInfoRequest request) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.auth.firstparty.dataservice.IGoogleAccountDataService");
                    if (request != null) {
                        obtain.writeInt(1);
                        request.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoz.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                    GplusInfoResponse createFromParcel = obtain2.readInt() != 0 ? GplusInfoResponse.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return createFromParcel;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public OtpResponse getOtp(OtpRequest request) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.auth.firstparty.dataservice.IGoogleAccountDataService");
                    if (request != null) {
                        obtain.writeInt(1);
                        request.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoz.transact(24, obtain, obtain2, 0);
                    obtain2.readException();
                    OtpResponse createFromParcel = obtain2.readInt() != 0 ? OtpResponse.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return createFromParcel;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public ReauthSettingsResponse getReauthSettings(ReauthSettingsRequest request) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.auth.firstparty.dataservice.IGoogleAccountDataService");
                    if (request != null) {
                        obtain.writeInt(1);
                        request.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoz.transact(21, obtain, obtain2, 0);
                    obtain2.readException();
                    ReauthSettingsResponse createFromParcel = obtain2.readInt() != 0 ? ReauthSettingsResponse.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return createFromParcel;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public TokenResponse getToken(TokenRequest request) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.auth.firstparty.dataservice.IGoogleAccountDataService");
                    if (request != null) {
                        obtain.writeInt(1);
                        request.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoz.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                    TokenResponse createFromParcel = obtain2.readInt() != 0 ? TokenResponse.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return createFromParcel;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public WebSetupConfig getWebSetupConfig(WebSetupConfigRequest request) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.auth.firstparty.dataservice.IGoogleAccountDataService");
                    if (request != null) {
                        obtain.writeInt(1);
                        request.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoz.transact(18, obtain, obtain2, 0);
                    obtain2.readException();
                    WebSetupConfig createFromParcel = obtain2.readInt() != 0 ? WebSetupConfig.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return createFromParcel;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean installAccountFromExportData(String accountName, Bundle exportData) throws RemoteException {
                boolean z = true;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.auth.firstparty.dataservice.IGoogleAccountDataService");
                    obtain.writeString(accountName);
                    if (exportData != null) {
                        obtain.writeInt(1);
                        exportData.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoz.transact(17, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() == 0) {
                        z = false;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return z;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public AccountRemovalResponse removeAccount(AccountRemovalRequest request) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.auth.firstparty.dataservice.IGoogleAccountDataService");
                    if (request != null) {
                        obtain.writeInt(1);
                        request.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoz.transact(20, obtain, obtain2, 0);
                    obtain2.readException();
                    AccountRemovalResponse createFromParcel = obtain2.readInt() != 0 ? AccountRemovalResponse.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return createFromParcel;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean setWorkAccountAppWhitelistFingerprint(String packageName, String signatureFingerprint) throws RemoteException {
                boolean z = false;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.auth.firstparty.dataservice.IGoogleAccountDataService");
                    obtain.writeString(packageName);
                    obtain.writeString(signatureFingerprint);
                    this.zzoz.transact(34, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return z;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public TokenResponse signIn(AccountSignInRequest request) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.auth.firstparty.dataservice.IGoogleAccountDataService");
                    if (request != null) {
                        obtain.writeInt(1);
                        request.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoz.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                    TokenResponse createFromParcel = obtain2.readInt() != 0 ? TokenResponse.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return createFromParcel;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public AccountRecoveryUpdateResult updateAccountRecoveryData(AccountRecoveryUpdateRequest request) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.auth.firstparty.dataservice.IGoogleAccountDataService");
                    if (request != null) {
                        obtain.writeInt(1);
                        request.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoz.transact(14, obtain, obtain2, 0);
                    obtain2.readException();
                    AccountRecoveryUpdateResult createFromParcel = obtain2.readInt() != 0 ? AccountRecoveryUpdateResult.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return createFromParcel;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public TokenResponse updateCredentials(UpdateCredentialsRequest request) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.auth.firstparty.dataservice.IGoogleAccountDataService");
                    if (request != null) {
                        obtain.writeInt(1);
                        request.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoz.transact(11, obtain, obtain2, 0);
                    obtain2.readException();
                    TokenResponse createFromParcel = obtain2.readInt() != 0 ? TokenResponse.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return createFromParcel;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public ValidateAccountCredentialsResponse validateAccountCredentials(AccountCredentials accountCreds) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.auth.firstparty.dataservice.IGoogleAccountDataService");
                    if (accountCreds != null) {
                        obtain.writeInt(1);
                        accountCreds.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoz.transact(36, obtain, obtain2, 0);
                    obtain2.readException();
                    ValidateAccountCredentialsResponse createFromParcel = obtain2.readInt() != 0 ? ValidateAccountCredentialsResponse.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return createFromParcel;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public VerifyPinResponse verifyPin(VerifyPinRequest request) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.auth.firstparty.dataservice.IGoogleAccountDataService");
                    if (request != null) {
                        obtain.writeInt(1);
                        request.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoz.transact(22, obtain, obtain2, 0);
                    obtain2.readException();
                    VerifyPinResponse createFromParcel = obtain2.readInt() != 0 ? VerifyPinResponse.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return createFromParcel;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public CheckFactoryResetPolicyComplianceResponse zza(CheckFactoryResetPolicyComplianceRequest checkFactoryResetPolicyComplianceRequest) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.auth.firstparty.dataservice.IGoogleAccountDataService");
                    if (checkFactoryResetPolicyComplianceRequest != null) {
                        obtain.writeInt(1);
                        checkFactoryResetPolicyComplianceRequest.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.zzoz.transact(27, obtain, obtain2, 0);
                    obtain2.readException();
                    CheckFactoryResetPolicyComplianceResponse createFromParcel = obtain2.readInt() != 0 ? CheckFactoryResetPolicyComplianceResponse.CREATOR.createFromParcel(obtain2) : null;
                    obtain2.recycle();
                    obtain.recycle();
                    return createFromParcel;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static zza zzaV(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.auth.firstparty.dataservice.IGoogleAccountDataService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zza)) ? new zza(iBinder) : (zza) queryLocalInterface;
        }

        public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
            AccountCredentials accountCredentials = null;
            int i = 0;
            GoogleAccountData accountData;
            GoogleAccountSetupRequest createFromParcel;
            TokenResponse createAccount;
            AccountRecoveryData accountRecoveryCountryInfo;
            Bundle accountExportData;
            boolean installAccountFromExportData;
            String accountId;
            Account account;
            switch (code) {
                case 1:
                    data.enforceInterface("com.google.android.gms.auth.firstparty.dataservice.IGoogleAccountDataService");
                    accountData = getAccountData(data.readString());
                    reply.writeNoException();
                    if (accountData != null) {
                        reply.writeInt(1);
                        accountData.writeToParcel(reply, 1);
                        return true;
                    }
                    reply.writeInt(0);
                    return true;
                case 2:
                    AccountNameCheckRequest createFromParcel2;
                    data.enforceInterface("com.google.android.gms.auth.firstparty.dataservice.IGoogleAccountDataService");
                    if (data.readInt() != 0) {
                        createFromParcel2 = AccountNameCheckRequest.CREATOR.createFromParcel(data);
                    }
                    AccountNameCheckResponse checkAccountName = checkAccountName(createFromParcel2);
                    reply.writeNoException();
                    if (checkAccountName != null) {
                        reply.writeInt(1);
                        checkAccountName.writeToParcel(reply, 1);
                        return true;
                    }
                    reply.writeInt(0);
                    return true;
                case 3:
                    PasswordCheckRequest createFromParcel3;
                    data.enforceInterface("com.google.android.gms.auth.firstparty.dataservice.IGoogleAccountDataService");
                    if (data.readInt() != 0) {
                        createFromParcel3 = PasswordCheckRequest.CREATOR.createFromParcel(data);
                    }
                    PasswordCheckResponse checkPassword = checkPassword(createFromParcel3);
                    reply.writeNoException();
                    if (checkPassword != null) {
                        reply.writeInt(1);
                        checkPassword.writeToParcel(reply, 1);
                        return true;
                    }
                    reply.writeInt(0);
                    return true;
                case 4:
                    CheckRealNameRequest createFromParcel4;
                    data.enforceInterface("com.google.android.gms.auth.firstparty.dataservice.IGoogleAccountDataService");
                    if (data.readInt() != 0) {
                        createFromParcel4 = CheckRealNameRequest.CREATOR.createFromParcel(data);
                    }
                    CheckRealNameResponse checkRealName = checkRealName(createFromParcel4);
                    reply.writeNoException();
                    if (checkRealName != null) {
                        reply.writeInt(1);
                        checkRealName.writeToParcel(reply, 1);
                        return true;
                    }
                    reply.writeInt(0);
                    return true;
                case 5:
                    data.enforceInterface("com.google.android.gms.auth.firstparty.dataservice.IGoogleAccountDataService");
                    if (data.readInt() != 0) {
                        createFromParcel = GoogleAccountSetupRequest.CREATOR.createFromParcel(data);
                    }
                    createAccount = createAccount(createFromParcel);
                    reply.writeNoException();
                    if (createAccount != null) {
                        reply.writeInt(1);
                        createAccount.writeToParcel(reply, 1);
                        return true;
                    }
                    reply.writeInt(0);
                    return true;
                case 6:
                    GplusInfoRequest createFromParcel5;
                    data.enforceInterface("com.google.android.gms.auth.firstparty.dataservice.IGoogleAccountDataService");
                    if (data.readInt() != 0) {
                        createFromParcel5 = GplusInfoRequest.CREATOR.createFromParcel(data);
                    }
                    GplusInfoResponse gplusInfo = getGplusInfo(createFromParcel5);
                    reply.writeNoException();
                    if (gplusInfo != null) {
                        reply.writeInt(1);
                        gplusInfo.writeToParcel(reply, 1);
                        return true;
                    }
                    reply.writeInt(0);
                    return true;
                case 7:
                    data.enforceInterface("com.google.android.gms.auth.firstparty.dataservice.IGoogleAccountDataService");
                    if (data.readInt() != 0) {
                        createFromParcel = GoogleAccountSetupRequest.CREATOR.createFromParcel(data);
                    }
                    createAccount = createPlusProfile(createFromParcel);
                    reply.writeNoException();
                    if (createAccount != null) {
                        reply.writeInt(1);
                        createAccount.writeToParcel(reply, 1);
                        return true;
                    }
                    reply.writeInt(0);
                    return true;
                case 8:
                    TokenRequest createFromParcel6;
                    data.enforceInterface("com.google.android.gms.auth.firstparty.dataservice.IGoogleAccountDataService");
                    if (data.readInt() != 0) {
                        createFromParcel6 = TokenRequest.CREATOR.createFromParcel(data);
                    }
                    createAccount = getToken(createFromParcel6);
                    reply.writeNoException();
                    if (createAccount != null) {
                        reply.writeInt(1);
                        createAccount.writeToParcel(reply, 1);
                        return true;
                    }
                    reply.writeInt(0);
                    return true;
                case 9:
                    AccountSignInRequest createFromParcel7;
                    data.enforceInterface("com.google.android.gms.auth.firstparty.dataservice.IGoogleAccountDataService");
                    if (data.readInt() != 0) {
                        createFromParcel7 = AccountSignInRequest.CREATOR.createFromParcel(data);
                    }
                    createAccount = signIn(createFromParcel7);
                    reply.writeNoException();
                    if (createAccount != null) {
                        reply.writeInt(1);
                        createAccount.writeToParcel(reply, 1);
                        return true;
                    }
                    reply.writeInt(0);
                    return true;
                case 10:
                    ConfirmCredentialsRequest createFromParcel8;
                    data.enforceInterface("com.google.android.gms.auth.firstparty.dataservice.IGoogleAccountDataService");
                    if (data.readInt() != 0) {
                        createFromParcel8 = ConfirmCredentialsRequest.CREATOR.createFromParcel(data);
                    }
                    createAccount = confirmCredentials(createFromParcel8);
                    reply.writeNoException();
                    if (createAccount != null) {
                        reply.writeInt(1);
                        createAccount.writeToParcel(reply, 1);
                        return true;
                    }
                    reply.writeInt(0);
                    return true;
                case 11:
                    UpdateCredentialsRequest createFromParcel9;
                    data.enforceInterface("com.google.android.gms.auth.firstparty.dataservice.IGoogleAccountDataService");
                    if (data.readInt() != 0) {
                        createFromParcel9 = UpdateCredentialsRequest.CREATOR.createFromParcel(data);
                    }
                    createAccount = updateCredentials(createFromParcel9);
                    reply.writeNoException();
                    if (createAccount != null) {
                        reply.writeInt(1);
                        createAccount.writeToParcel(reply, 1);
                        return true;
                    }
                    reply.writeInt(0);
                    return true;
                case 12:
                    data.enforceInterface("com.google.android.gms.auth.firstparty.dataservice.IGoogleAccountDataService");
                    accountRecoveryCountryInfo = getAccountRecoveryCountryInfo();
                    reply.writeNoException();
                    if (accountRecoveryCountryInfo != null) {
                        reply.writeInt(1);
                        accountRecoveryCountryInfo.writeToParcel(reply, 1);
                        return true;
                    }
                    reply.writeInt(0);
                    return true;
                case 13:
                    AccountRecoveryDataRequest createFromParcel10;
                    data.enforceInterface("com.google.android.gms.auth.firstparty.dataservice.IGoogleAccountDataService");
                    if (data.readInt() != 0) {
                        createFromParcel10 = AccountRecoveryDataRequest.CREATOR.createFromParcel(data);
                    }
                    accountRecoveryCountryInfo = getAccountRecoveryData(createFromParcel10);
                    reply.writeNoException();
                    if (accountRecoveryCountryInfo != null) {
                        reply.writeInt(1);
                        accountRecoveryCountryInfo.writeToParcel(reply, 1);
                        return true;
                    }
                    reply.writeInt(0);
                    return true;
                case 14:
                    AccountRecoveryUpdateRequest createFromParcel11;
                    data.enforceInterface("com.google.android.gms.auth.firstparty.dataservice.IGoogleAccountDataService");
                    if (data.readInt() != 0) {
                        createFromParcel11 = AccountRecoveryUpdateRequest.CREATOR.createFromParcel(data);
                    }
                    AccountRecoveryUpdateResult updateAccountRecoveryData = updateAccountRecoveryData(createFromParcel11);
                    reply.writeNoException();
                    if (updateAccountRecoveryData != null) {
                        reply.writeInt(1);
                        updateAccountRecoveryData.writeToParcel(reply, 1);
                        return true;
                    }
                    reply.writeInt(0);
                    return true;
                case 15:
                    AccountRecoveryGuidanceRequest createFromParcel12;
                    data.enforceInterface("com.google.android.gms.auth.firstparty.dataservice.IGoogleAccountDataService");
                    if (data.readInt() != 0) {
                        createFromParcel12 = AccountRecoveryGuidanceRequest.CREATOR.createFromParcel(data);
                    }
                    AccountRecoveryGuidance accountRecoveryGuidance = getAccountRecoveryGuidance(createFromParcel12);
                    reply.writeNoException();
                    if (accountRecoveryGuidance != null) {
                        reply.writeInt(1);
                        accountRecoveryGuidance.writeToParcel(reply, 1);
                        return true;
                    }
                    reply.writeInt(0);
                    return true;
                case 16:
                    data.enforceInterface("com.google.android.gms.auth.firstparty.dataservice.IGoogleAccountDataService");
                    accountExportData = getAccountExportData(data.readString());
                    reply.writeNoException();
                    if (accountExportData != null) {
                        reply.writeInt(1);
                        accountExportData.writeToParcel(reply, 1);
                        return true;
                    }
                    reply.writeInt(0);
                    return true;
                case 17:
                    data.enforceInterface("com.google.android.gms.auth.firstparty.dataservice.IGoogleAccountDataService");
                    String readString = data.readString();
                    if (data.readInt() != 0) {
                        accountExportData = (Bundle) Bundle.CREATOR.createFromParcel(data);
                    }
                    installAccountFromExportData = installAccountFromExportData(readString, accountExportData);
                    reply.writeNoException();
                    reply.writeInt(installAccountFromExportData ? 1 : 0);
                    return true;
                case 18:
                    WebSetupConfigRequest createFromParcel13;
                    data.enforceInterface("com.google.android.gms.auth.firstparty.dataservice.IGoogleAccountDataService");
                    if (data.readInt() != 0) {
                        createFromParcel13 = WebSetupConfigRequest.CREATOR.createFromParcel(data);
                    }
                    WebSetupConfig webSetupConfig = getWebSetupConfig(createFromParcel13);
                    reply.writeNoException();
                    if (webSetupConfig != null) {
                        reply.writeInt(1);
                        webSetupConfig.writeToParcel(reply, 1);
                        return true;
                    }
                    reply.writeInt(0);
                    return true;
                case 19:
                    ClearTokenRequest createFromParcel14;
                    data.enforceInterface("com.google.android.gms.auth.firstparty.dataservice.IGoogleAccountDataService");
                    if (data.readInt() != 0) {
                        createFromParcel14 = ClearTokenRequest.CREATOR.createFromParcel(data);
                    }
                    ClearTokenResponse clearToken = clearToken(createFromParcel14);
                    reply.writeNoException();
                    if (clearToken != null) {
                        reply.writeInt(1);
                        clearToken.writeToParcel(reply, 1);
                        return true;
                    }
                    reply.writeInt(0);
                    return true;
                case 20:
                    AccountRemovalRequest createFromParcel15;
                    data.enforceInterface("com.google.android.gms.auth.firstparty.dataservice.IGoogleAccountDataService");
                    if (data.readInt() != 0) {
                        createFromParcel15 = AccountRemovalRequest.CREATOR.createFromParcel(data);
                    }
                    AccountRemovalResponse removeAccount = removeAccount(createFromParcel15);
                    reply.writeNoException();
                    if (removeAccount != null) {
                        reply.writeInt(1);
                        removeAccount.writeToParcel(reply, 1);
                        return true;
                    }
                    reply.writeInt(0);
                    return true;
                case 21:
                    ReauthSettingsRequest createFromParcel16;
                    data.enforceInterface("com.google.android.gms.auth.firstparty.dataservice.IGoogleAccountDataService");
                    if (data.readInt() != 0) {
                        createFromParcel16 = ReauthSettingsRequest.CREATOR.createFromParcel(data);
                    }
                    ReauthSettingsResponse reauthSettings = getReauthSettings(createFromParcel16);
                    reply.writeNoException();
                    if (reauthSettings != null) {
                        reply.writeInt(1);
                        reauthSettings.writeToParcel(reply, 1);
                        return true;
                    }
                    reply.writeInt(0);
                    return true;
                case 22:
                    VerifyPinRequest createFromParcel17;
                    data.enforceInterface("com.google.android.gms.auth.firstparty.dataservice.IGoogleAccountDataService");
                    if (data.readInt() != 0) {
                        createFromParcel17 = VerifyPinRequest.CREATOR.createFromParcel(data);
                    }
                    VerifyPinResponse verifyPin = verifyPin(createFromParcel17);
                    reply.writeNoException();
                    if (verifyPin != null) {
                        reply.writeInt(1);
                        verifyPin.writeToParcel(reply, 1);
                        return true;
                    }
                    reply.writeInt(0);
                    return true;
                case 23:
                    AccountChangeEventsRequest accountChangeEventsRequest;
                    data.enforceInterface("com.google.android.gms.auth.firstparty.dataservice.IGoogleAccountDataService");
                    if (data.readInt() != 0) {
                        accountChangeEventsRequest = (AccountChangeEventsRequest) AccountChangeEventsRequest.CREATOR.createFromParcel(data);
                    }
                    AccountChangeEventsResponse accountChangeEvents = getAccountChangeEvents(accountChangeEventsRequest);
                    reply.writeNoException();
                    if (accountChangeEvents != null) {
                        reply.writeInt(1);
                        accountChangeEvents.writeToParcel(reply, 1);
                        return true;
                    }
                    reply.writeInt(0);
                    return true;
                case 24:
                    OtpRequest createFromParcel18;
                    data.enforceInterface("com.google.android.gms.auth.firstparty.dataservice.IGoogleAccountDataService");
                    if (data.readInt() != 0) {
                        createFromParcel18 = OtpRequest.CREATOR.createFromParcel(data);
                    }
                    OtpResponse otp = getOtp(createFromParcel18);
                    reply.writeNoException();
                    if (otp != null) {
                        reply.writeInt(1);
                        otp.writeToParcel(reply, 1);
                        return true;
                    }
                    reply.writeInt(0);
                    return true;
                case 25:
                    data.enforceInterface("com.google.android.gms.auth.firstparty.dataservice.IGoogleAccountDataService");
                    accountId = getAccountId(data.readString());
                    reply.writeNoException();
                    reply.writeString(accountId);
                    return true;
                case LogSource.CW /*27*/:
                    CheckFactoryResetPolicyComplianceRequest createFromParcel19;
                    data.enforceInterface("com.google.android.gms.auth.firstparty.dataservice.IGoogleAccountDataService");
                    if (data.readInt() != 0) {
                        createFromParcel19 = CheckFactoryResetPolicyComplianceRequest.CREATOR.createFromParcel(data);
                    }
                    CheckFactoryResetPolicyComplianceResponse zza = zza(createFromParcel19);
                    reply.writeNoException();
                    if (zza != null) {
                        reply.writeInt(1);
                        zza.writeToParcel(reply, 1);
                        return true;
                    }
                    reply.writeInt(0);
                    return true;
                case LogSource.DNA_PROBER /*29*/:
                    data.enforceInterface("com.google.android.gms.auth.firstparty.dataservice.IGoogleAccountDataService");
                    clearFactoryResetChallenges();
                    reply.writeNoException();
                    return true;
                case LogSource.UDR /*30*/:
                    data.enforceInterface("com.google.android.gms.auth.firstparty.dataservice.IGoogleAccountDataService");
                    if (data.readInt() != 0) {
                        account = (Account) Account.CREATOR.createFromParcel(data);
                    }
                    accountData = getGoogleAccountData(account);
                    reply.writeNoException();
                    if (accountData != null) {
                        reply.writeInt(1);
                        accountData.writeToParcel(reply, 1);
                        return true;
                    }
                    reply.writeInt(0);
                    return true;
                case LogSource.GMS_CORE_WALLET /*31*/:
                    data.enforceInterface("com.google.android.gms.auth.firstparty.dataservice.IGoogleAccountDataService");
                    if (data.readInt() != 0) {
                        account = (Account) Account.CREATOR.createFromParcel(data);
                    }
                    accountId = getGoogleAccountId(account);
                    reply.writeNoException();
                    reply.writeString(accountId);
                    return true;
                case 34:
                    data.enforceInterface("com.google.android.gms.auth.firstparty.dataservice.IGoogleAccountDataService");
                    installAccountFromExportData = setWorkAccountAppWhitelistFingerprint(data.readString(), data.readString());
                    reply.writeNoException();
                    if (installAccountFromExportData) {
                        i = 1;
                    }
                    reply.writeInt(i);
                    return true;
                case MotionEventCompat.AXIS_GENERIC_4 /*35*/:
                    data.enforceInterface("com.google.android.gms.auth.firstparty.dataservice.IGoogleAccountDataService");
                    installAccountFromExportData = clearWorkAccountAppWhitelist();
                    reply.writeNoException();
                    if (installAccountFromExportData) {
                        i = 1;
                    }
                    reply.writeInt(i);
                    return true;
                case 36:
                    data.enforceInterface("com.google.android.gms.auth.firstparty.dataservice.IGoogleAccountDataService");
                    if (data.readInt() != 0) {
                        accountCredentials = AccountCredentials.CREATOR.createFromParcel(data);
                    }
                    ValidateAccountCredentialsResponse validateAccountCredentials = validateAccountCredentials(accountCredentials);
                    reply.writeNoException();
                    if (validateAccountCredentials != null) {
                        reply.writeInt(1);
                        validateAccountCredentials.writeToParcel(reply, 1);
                        return true;
                    }
                    reply.writeInt(0);
                    return true;
                case MotionEventCompat.AXIS_GENERIC_6 /*37*/:
                    data.enforceInterface("com.google.android.gms.auth.firstparty.dataservice.IGoogleAccountDataService");
                    GetAndAdvanceOtpCounterResponse andAdvanceOtpCounter = getAndAdvanceOtpCounter(data.readString());
                    reply.writeNoException();
                    if (andAdvanceOtpCounter != null) {
                        reply.writeInt(1);
                        andAdvanceOtpCounter.writeToParcel(reply, 1);
                        return true;
                    }
                    reply.writeInt(0);
                    return true;
                case 1598968902:
                    reply.writeString("com.google.android.gms.auth.firstparty.dataservice.IGoogleAccountDataService");
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }
    }

    AccountNameCheckResponse checkAccountName(AccountNameCheckRequest accountNameCheckRequest) throws RemoteException;

    PasswordCheckResponse checkPassword(PasswordCheckRequest passwordCheckRequest) throws RemoteException;

    CheckRealNameResponse checkRealName(CheckRealNameRequest checkRealNameRequest) throws RemoteException;

    void clearFactoryResetChallenges() throws RemoteException;

    ClearTokenResponse clearToken(ClearTokenRequest clearTokenRequest) throws RemoteException;

    boolean clearWorkAccountAppWhitelist() throws RemoteException;

    TokenResponse confirmCredentials(ConfirmCredentialsRequest confirmCredentialsRequest) throws RemoteException;

    TokenResponse createAccount(GoogleAccountSetupRequest googleAccountSetupRequest) throws RemoteException;

    TokenResponse createPlusProfile(GoogleAccountSetupRequest googleAccountSetupRequest) throws RemoteException;

    AccountChangeEventsResponse getAccountChangeEvents(AccountChangeEventsRequest accountChangeEventsRequest) throws RemoteException;

    GoogleAccountData getAccountData(String str) throws RemoteException;

    Bundle getAccountExportData(String str) throws RemoteException;

    String getAccountId(String str) throws RemoteException;

    AccountRecoveryData getAccountRecoveryCountryInfo() throws RemoteException;

    AccountRecoveryData getAccountRecoveryData(AccountRecoveryDataRequest accountRecoveryDataRequest) throws RemoteException;

    AccountRecoveryGuidance getAccountRecoveryGuidance(AccountRecoveryGuidanceRequest accountRecoveryGuidanceRequest) throws RemoteException;

    GetAndAdvanceOtpCounterResponse getAndAdvanceOtpCounter(String str) throws RemoteException;

    GoogleAccountData getGoogleAccountData(Account account) throws RemoteException;

    String getGoogleAccountId(Account account) throws RemoteException;

    GplusInfoResponse getGplusInfo(GplusInfoRequest gplusInfoRequest) throws RemoteException;

    OtpResponse getOtp(OtpRequest otpRequest) throws RemoteException;

    ReauthSettingsResponse getReauthSettings(ReauthSettingsRequest reauthSettingsRequest) throws RemoteException;

    TokenResponse getToken(TokenRequest tokenRequest) throws RemoteException;

    WebSetupConfig getWebSetupConfig(WebSetupConfigRequest webSetupConfigRequest) throws RemoteException;

    boolean installAccountFromExportData(String str, Bundle bundle) throws RemoteException;

    AccountRemovalResponse removeAccount(AccountRemovalRequest accountRemovalRequest) throws RemoteException;

    boolean setWorkAccountAppWhitelistFingerprint(String str, String str2) throws RemoteException;

    TokenResponse signIn(AccountSignInRequest accountSignInRequest) throws RemoteException;

    AccountRecoveryUpdateResult updateAccountRecoveryData(AccountRecoveryUpdateRequest accountRecoveryUpdateRequest) throws RemoteException;

    TokenResponse updateCredentials(UpdateCredentialsRequest updateCredentialsRequest) throws RemoteException;

    ValidateAccountCredentialsResponse validateAccountCredentials(AccountCredentials accountCredentials) throws RemoteException;

    VerifyPinResponse verifyPin(VerifyPinRequest verifyPinRequest) throws RemoteException;

    CheckFactoryResetPolicyComplianceResponse zza(CheckFactoryResetPolicyComplianceRequest checkFactoryResetPolicyComplianceRequest) throws RemoteException;
}
