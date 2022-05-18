package no.nav.helsearbeidsgiver.norg2

import java.time.LocalDate

fun lagResponse(): List<ArbeidsfordelingResponse> =
    listOf(
        ArbeidsfordelingResponse(
            aktiveringsdato = LocalDate.of(2020, 12, 31),
            antallRessurser = 0,
            enhetId = 123456789,
            enhetNr = "1234",
            kanalstrategi = null,
            navn = "NAV Område",
            nedleggelsesdato = null,
            oppgavebehandler = false,
            orgNivaa = "SPESEN",
            orgNrTilKommunaltNavKontor = "",
            organisasjonsnummer = null,
            sosialeTjenester = "",
            status = "Aktiv",
            type = "KO",
            underAvviklingDato = null,
            underEtableringDato = LocalDate.of(2020, 11, 30),
            versjon = 1
        )
    )
