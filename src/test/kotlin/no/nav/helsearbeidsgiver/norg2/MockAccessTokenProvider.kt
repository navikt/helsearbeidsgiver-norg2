package no.nav.helsearbeidsgiver.norg2

import no.nav.helsearbeidsgiver.tokenprovider.AccessTokenProvider

class MockAccessTokenProvider : AccessTokenProvider {

    override fun getToken(): String {
        return "token"
    }
}
