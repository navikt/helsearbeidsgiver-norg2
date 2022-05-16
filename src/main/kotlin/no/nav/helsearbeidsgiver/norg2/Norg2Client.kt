package no.nav.helsearbeidsgiver.norg2

import io.ktor.client.HttpClient
import io.ktor.client.request.header
import io.ktor.client.request.post
import io.ktor.http.ContentType
import io.ktor.http.contentType
import io.ktor.http.withCharset
import kotlinx.coroutines.runBlocking
import no.nav.helsearbeidsgiver.tokenprovider.AccessTokenProvider

/**
 * Klient som henter alle arbeidsfordelinger
 *
 * Dokumentasjon
 * https://confluence.adeo.no/pages/viewpage.action?pageId=178072651
 *
 * Swagger
 * https://norg2.dev.adeo.no/norg2/swagger-ui.html#/arbeidsfordeling/findArbeidsfordelingByCriteriaUsingPOST
 *
 */
open class Norg2Client(
    private val url: String,
    private val accessTokenProvider: AccessTokenProvider,
    private val httpClient: HttpClient
) {

    /**
     * Oppslag av informasjon om ruting av arbeidsoppgaver til enheter.
     */
    open suspend fun hentAlleArbeidsfordelinger(request: ArbeidsfordelingRequest, callId: String?): List<ArbeidsfordelingResponse> {
        val stsToken = accessTokenProvider.getToken()
        return runBlocking {
            httpClient.post<List<ArbeidsfordelingResponse>>(url + "/arbeidsfordeling/enheter/bestmatch") {
                contentType(ContentType.Application.Json.withCharset(Charsets.UTF_8))
                header("Authorization", "Bearer $stsToken")
                header("X-Correlation-ID", callId)
                body = request
            }
        }
    }
}
