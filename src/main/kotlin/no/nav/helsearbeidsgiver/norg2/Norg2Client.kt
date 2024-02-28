package no.nav.helsearbeidsgiver.norg2

import io.ktor.client.HttpClient
import io.ktor.client.request.header
import io.ktor.client.request.post
import io.ktor.http.ContentType
import io.ktor.http.contentType
import io.ktor.http.withCharset
import kotlinx.coroutines.runBlocking

interface INorg2Client {
    suspend fun hentAlleArbeidsfordelinger(request: ArbeidsfordelingRequest, callId: String?): List<ArbeidsfordelingResponse>
}

interface INorg2ClientSync {
    fun hentAlleArbeidsfordelingerSync(request: ArbeidsfordelingRequest, callId: String?): List<ArbeidsfordelingResponse>
}

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
class Norg2Client(
    private val url: String,
    private val httpClient: HttpClient,
    private val getAccessToken: () -> String,
): INorg2Client, INorg2ClientSync {

    /**
     * Oppslag av informasjon om ruting av arbeidsoppgaver til enheter.
     */
    override suspend fun hentAlleArbeidsfordelinger(request: ArbeidsfordelingRequest, callId: String?): List<ArbeidsfordelingResponse> {
        val accessToken = getAccessToken()
        return httpClient.post(url + "/arbeidsfordeling/enheter/bestmatch") {
            contentType(ContentType.Application.Json.withCharset(Charsets.UTF_8))
            header("Authorization", "Bearer $accessToken")
            header("X-Correlation-ID", callId)
            body = request
        }
    }

    override fun hentAlleArbeidsfordelingerSync(request: ArbeidsfordelingRequest, callId: String?) : List<ArbeidsfordelingResponse> {
        return runBlocking { hentAlleArbeidsfordelinger(request, callId) }
    }

}
