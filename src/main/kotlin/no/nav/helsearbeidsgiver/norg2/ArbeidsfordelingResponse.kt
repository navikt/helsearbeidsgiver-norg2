package no.nav.helsearbeidsgiver.norg2

import kotlinx.serialization.Serializable
import java.time.LocalDate

@Serializable
data class ArbeidsfordelingResponse(
    @Serializable(with = LocalDateSerializer::class)
    val aktiveringsdato: LocalDate?,
    val antallRessurser: Int?,
    val enhetId: Int,
    val enhetNr: String? = null,
    val kanalstrategi: String?,
    val navn: String,
    @Serializable(with = LocalDateSerializer::class)
    val nedleggelsesdato: LocalDate?,
    val oppgavebehandler: Boolean?,
    val orgNivaa: String?,
    val orgNrTilKommunaltNavKontor: String?,
    val organisasjonsnummer: String?,
    val sosialeTjenester: String?,
    val status: String?,
    val type: String?,
    @Serializable(with = LocalDateSerializer::class)
    val underAvviklingDato: LocalDate?,
    @Serializable(with = LocalDateSerializer::class)
    val underEtableringDato: LocalDate?,
    val versjon: Int?
)
