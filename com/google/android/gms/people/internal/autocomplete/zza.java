package com.google.android.gms.people.internal.autocomplete;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.PendingResults;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.zza.zzb;
import com.google.android.gms.common.api.internal.zzt;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.people.Autocomplete.AutocompleteSession;
import com.google.android.gms.people.Autocomplete.Autocompletion;
import com.google.android.gms.people.Autocomplete.AutocompletionListener;
import com.google.android.gms.people.Autocomplete.ClientConfig;
import com.google.android.gms.people.Autocomplete.ContactGroup;
import com.google.android.gms.people.Autocomplete.LoadPhotoOptions;
import com.google.android.gms.people.Autocomplete.LoadPhotoResult;
import com.google.android.gms.people.Autocomplete.Person;
import com.google.android.gms.people.Autocomplete.Photo;
import com.google.android.gms.people.Autocomplete.PreferredFieldsResult;
import com.google.android.gms.people.Images.LoadImageOptions.Builder;
import com.google.android.gms.people.Images.LoadImageResult;
import com.google.android.gms.people.People;
import com.google.android.gms.people.internal.zzn;
import com.google.android.gms.people.internal.zzn.zzd;
import com.google.android.gms.people.internal.zzn.zzj;
import com.google.android.gms.people.model.AvatarReference;
import com.google.android.gms.people.model.ContactGroupPreferredFieldsBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class zza implements AutocompleteSession {
    private static long zzbHP = 0;
    public String mAccount;
    private boolean zzbHJ = false;
    private AutocompletionListener zzbHK;
    private ClientConfig zzbHL;
    private long zzbHM;
    private zza zzbHN;
    private com.google.android.gms.people.People.zza<zzj> zzbHO;

    private static class zza implements zzd {
        private AutocompletionListener zzbHK;
        private boolean zzbHV = false;
        private volatile boolean zzbHW = false;
        private Set<Integer> zzbHX = new HashSet();
        private Map<Integer, List<Autocompletion>> zzbHY = new HashMap();
        private zza zzbHZ;

        public zza(zza com_google_android_gms_people_internal_autocomplete_zza, AutocompletionListener autocompletionListener) {
            this.zzbHZ = com_google_android_gms_people_internal_autocomplete_zza;
            this.zzbHK = autocompletionListener;
        }

        private void onAutocompletionsAvailable(Autocompletion[] autocompletions, int callbackNumber, int callbackTotal) {
            this.zzbHK.onAutocompletionsAvailable(autocompletions, callbackNumber, callbackTotal);
            if (callbackNumber == callbackTotal - 1) {
                this.zzbHW = true;
            }
        }

        private List<Autocompletion> zzb(zzj com_google_android_gms_people_internal_zzn_zzj) {
            List<Autocompletion> arrayList = new ArrayList(com_google_android_gms_people_internal_zzn_zzj.zzJu().size());
            Iterator it = com_google_android_gms_people_internal_zzn_zzj.zzJu().iterator();
            while (it.hasNext()) {
                arrayList.add((AutocompletionImpl) it.next());
            }
            return arrayList;
        }

        public final synchronized void cancel() {
            this.zzbHV = true;
        }

        public final boolean isFinished() {
            return this.zzbHW;
        }

        public synchronized void zza(zzj com_google_android_gms_people_internal_zzn_zzj) {
            if (!this.zzbHV) {
                if (com_google_android_gms_people_internal_zzn_zzj.zzJv() == 0 || this.zzbHX.contains(Integer.valueOf(com_google_android_gms_people_internal_zzn_zzj.zzJv() - 1))) {
                    this.zzbHX.add(Integer.valueOf(com_google_android_gms_people_internal_zzn_zzj.zzJv()));
                    onAutocompletionsAvailable((Autocompletion[]) zzb(com_google_android_gms_people_internal_zzn_zzj).toArray(new Autocompletion[0]), com_google_android_gms_people_internal_zzn_zzj.zzJv(), com_google_android_gms_people_internal_zzn_zzj.zzJw());
                    for (int zzJv = com_google_android_gms_people_internal_zzn_zzj.zzJv() + 1; this.zzbHY.containsKey(Integer.valueOf(zzJv)); zzJv++) {
                        onAutocompletionsAvailable((Autocompletion[]) ((List) this.zzbHY.get(Integer.valueOf(zzJv))).toArray(new Autocompletion[0]), zzJv, com_google_android_gms_people_internal_zzn_zzj.zzJw());
                        this.zzbHY.remove(Integer.valueOf(zzJv));
                        this.zzbHX.add(Integer.valueOf(zzJv));
                    }
                } else {
                    this.zzbHY.put(Integer.valueOf(com_google_android_gms_people_internal_zzn_zzj.zzJv()), zzb(com_google_android_gms_people_internal_zzn_zzj));
                }
            }
        }

        public final void zzcg(Status status) {
        }
    }

    public zza(GoogleApiClient googleApiClient, ClientConfig clientConfig, String str, AutocompletionListener autocompletionListener) {
        this.mAccount = (String) zzx.zzD(str);
        zzx.zzD(googleApiClient);
        this.zzbHK = (AutocompletionListener) zzx.zzD(autocompletionListener);
        this.zzbHM = zzJW();
        this.zzbHL = (ClientConfig) zzx.zzD(clientConfig);
        this.zzbHO = null;
    }

    private synchronized void zzJV() {
        if (this.zzbHJ) {
            throw new IllegalStateException("AutocompleteSession has already been closed.");
        }
    }

    private static synchronized long zzJW() {
        long j;
        synchronized (zza.class) {
            j = zzbHP;
            zzbHP++;
        }
        return j;
    }

    private PendingResult<LoadPhotoResult> zza(GoogleApiClient googleApiClient, PhotoImpl photoImpl, LoadPhotoOptions loadPhotoOptions) {
        zzx.zzD(googleApiClient);
        return zzb(People.ImageApi.loadByReference(googleApiClient, new AvatarReference(photoImpl.getSource(), photoImpl.getLocation()), new Builder().setImageSize(loadPhotoOptions.getImageSize()).setAvatarOptions(loadPhotoOptions.getPhotoOptions()).build()));
    }

    private zza zza(GoogleApiClient googleApiClient, final String str) {
        zzx.zzD(googleApiClient);
        final zza com_google_android_gms_people_internal_autocomplete_zza_zza = new zza(this, this.zzbHK);
        if (!(this.zzbHO == null || this.zzbHN.isFinished())) {
            this.zzbHO.cancel();
        }
        this.zzbHO = (com.google.android.gms.people.People.zza) googleApiClient.zza(new com.google.android.gms.people.People.zza<zzj>(this, googleApiClient) {
            final /* synthetic */ zza zzbHR;

            protected void zza(zzn com_google_android_gms_people_internal_zzn) throws RemoteException {
                zza(com_google_android_gms_people_internal_zzn.zza(com_google_android_gms_people_internal_autocomplete_zza_zza, this.zzbHR.mAccount, str, this.zzbHR.zzbHM, this.zzbHR.zzbHL.clientId));
            }

            protected /* synthetic */ Result zzb(Status status) {
                return zzcw(status);
            }

            protected zzj zzcw(final Status status) {
                return new zzj(this) {
                    final /* synthetic */ C05811 zzbHS;

                    public Status getStatus() {
                        return status;
                    }

                    public void release() {
                    }

                    public ArrayList<AutocompletionImpl> zzJu() {
                        return null;
                    }

                    public int zzJv() {
                        return 0;
                    }

                    public int zzJw() {
                        return 0;
                    }
                };
            }
        });
        return com_google_android_gms_people_internal_autocomplete_zza_zza;
    }

    private static PendingResult<LoadPhotoResult> zzb(PendingResult<LoadImageResult> pendingResult) {
        return new zzt<LoadImageResult, LoadPhotoResult>(pendingResult) {
            protected LoadPhotoResult zza(LoadImageResult loadImageResult) {
                return new LoadPhotoResult(loadImageResult.getStatus(), loadImageResult.getParcelFileDescriptor(), loadImageResult.isRewindable(), loadImageResult.getWidth(), loadImageResult.getHeight());
            }

            protected /* synthetic */ Result zzd(Result result) {
                return zza((LoadImageResult) result);
            }
        };
    }

    public synchronized void adjustQuery(GoogleApiClient client, String enteredText) {
        zzx.zzD(client);
        zzx.zzD(enteredText);
        zzJV();
        if (this.zzbHN != null) {
            this.zzbHN.cancel();
        }
        if (!enteredText.isEmpty()) {
            this.zzbHN = zza(client, enteredText);
        }
    }

    public synchronized void close(GoogleApiClient client) {
        zzx.zzD(client);
        zzJV();
        if (this.zzbHN != null) {
            this.zzbHN.cancel();
        }
        if (this.zzbHO != null) {
            this.zzbHO.cancel();
        }
        this.zzbHJ = true;
    }

    public PendingResult<PreferredFieldsResult> getAllPreferredFields(GoogleApiClient client, final ContactGroup contactGroup) {
        zzx.zzb((Object) client, (Object) "The GoogleApiClient cannot be null.");
        zzx.zzb((Object) contactGroup, (Object) "The ContactGroup cannot be null.");
        return client.zza(new com.google.android.gms.people.People.zza<PreferredFieldsResult>(this, client) {
            final /* synthetic */ zza zzbHR;

            protected void zza(zzn com_google_android_gms_people_internal_zzn) throws RemoteException {
                com_google_android_gms_people_internal_zzn.zzg((zzb) this, this.zzbHR.mAccount, contactGroup.getId().getId());
            }

            protected /* synthetic */ Result zzb(Status status) {
                return zzcx(status);
            }

            protected PreferredFieldsResult zzcx(final Status status) {
                return new PreferredFieldsResult(this) {
                    final /* synthetic */ C05843 zzbHU;

                    public ContactGroupPreferredFieldsBuffer getPreferredFields() {
                        return null;
                    }

                    public Status getStatus() {
                        return status;
                    }

                    public void release() {
                    }
                };
            }
        });
    }

    public PendingResult<LoadPhotoResult> loadPrimaryPhoto(GoogleApiClient client, Person person, LoadPhotoOptions photoOptions) {
        zzx.zzb((Object) client, (Object) "The client cannot be null");
        zzx.zzb((Object) person, (Object) "The person cannot be null");
        zzx.zzb(person instanceof PersonImpl, (Object) "The person must be provided by the Autocomplete Session.");
        for (Photo photo : person.getPhotos()) {
            if (photo.isDefault()) {
                return zza(client, (PhotoImpl) photo, photoOptions);
            }
        }
        return PendingResults.immediatePendingResult(LoadPhotoResult.FAILED_RESULT);
    }

    public void reportDisplay(GoogleApiClient client, Autocompletion autocompletion) {
        zzx.zzb((Object) client, (Object) "The client cannot be null");
        zzx.zzb((Object) autocompletion, (Object) "The autocompletion cannot be null");
    }

    public void reportSelection(GoogleApiClient client, Autocompletion autocompletion) {
        zzx.zzb((Object) client, (Object) "The client cannot be null");
        zzx.zzb((Object) autocompletion, (Object) "The autocompletion cannot be null");
    }

    public void reportSubmissionSave(GoogleApiClient client, Autocompletion autocompletion, String[] ids) {
        zzx.zzb((Object) client, (Object) "The client cannot be null");
        zzx.zzb((Object) autocompletion, (Object) "The autocompletion cannot be null");
    }

    public void reportSubmissionSend(GoogleApiClient client, Autocompletion autocompletion, String[] ids) {
        zzx.zzb((Object) client, (Object) "The client cannot be null");
        zzx.zzb((Object) autocompletion, (Object) "The autocompletion cannot be null");
    }

    public void startNewQuery(GoogleApiClient client) {
        zzx.zzD(client);
        adjustQuery(client, "");
    }
}
