
// Copyright 2014 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

// This file is autogenerated by:
//     mojo/public/tools/bindings/mojom_bindings_generator.py
// For:
//     services/network/public/mojom/network_service.mojom
//

package org.chromium.network.mojom;

import org.chromium.mojo.bindings.DeserializationException;


public interface NetworkServiceClient extends org.chromium.mojo.bindings.Interface {



    public interface Proxy extends NetworkServiceClient, org.chromium.mojo.bindings.Interface.Proxy {
    }

    Manager<NetworkServiceClient, NetworkServiceClient.Proxy> MANAGER = NetworkServiceClient_Internal.MANAGER;


    void onAuthRequired(
int processId, int routingId, org.chromium.url.mojom.Url url, boolean firstAuthAttempt, AuthChallengeInfo authInfo, 
OnAuthRequiredResponse callback);

    interface OnAuthRequiredResponse extends org.chromium.mojo.bindings.Callbacks.Callback1<AuthCredentials> { }



    void onCertificateRequested(
int processId, int routingId, SslCertRequestInfo certInfo, 
OnCertificateRequestedResponse callback);

    interface OnCertificateRequestedResponse extends org.chromium.mojo.bindings.Callbacks.Callback4<X509Certificate, short[], SslPrivateKey, Boolean> { }



    void onSslCertificateError(
int resourceType, org.chromium.url.mojom.Url url, int processId, int routingId, SslInfo sslInfo, boolean fatal, 
OnSslCertificateErrorResponse callback);

    interface OnSslCertificateErrorResponse extends org.chromium.mojo.bindings.Callbacks.Callback1<Integer> { }


}