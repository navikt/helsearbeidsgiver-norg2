package no.nav.helsearbeidsgiver.norg2

import io.ktor.http.*

fun buildClient(status: HttpStatusCode, content: String): Norg2Client {
    return Norg2Client(
        "",
        "",
        mockHttpClient(status, content)
    )
}

