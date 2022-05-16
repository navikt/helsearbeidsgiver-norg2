package no.nav.helsearbeidsgiver.norg2

import java.time.LocalDate

data class ArbeidsfordelingResponse(
    val aktiveringsdato: LocalDate?,
    val antallRessurser: Int?,
    val enhetId: Int,
    val enhetNr: String? = null,
    val kanalstrategi: String?,
    val navn: String,
    val nedleggelsesdato: LocalDate?,
    val oppgavebehandler: Boolean?,
    val orgNivaa: String?,
    val orgNrTilKommunaltNavKontor: String?,
    val organisasjonsnummer: String?,
    val sosialeTjenester: String?,
    val status: String?,
    val type: String?,
    val underAvviklingDato: LocalDate?,
    val underEtableringDato: LocalDate?,
    val versjon: Int?
)
