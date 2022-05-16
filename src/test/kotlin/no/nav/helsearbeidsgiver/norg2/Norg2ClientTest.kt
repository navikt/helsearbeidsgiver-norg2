package no.nav.helsearbeidsgiver.norg2

import io.ktor.http.HttpStatusCode
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Norg2ClientTest {

    private lateinit var norgClient: Norg2Client

    @Test
    fun hentAlleArbeidsfordelinger() {
        runBlocking {
            norgClient = buildClient(HttpStatusCode.OK, "")
            val arbeidsfordelinger = norgClient.hentAlleArbeidsfordelinger(lagRequest(), "123")
            assertEquals(1, arbeidsfordelinger.size)
            assertEquals("1234", arbeidsfordelinger[0].enhetNr)
        }
    }
}
