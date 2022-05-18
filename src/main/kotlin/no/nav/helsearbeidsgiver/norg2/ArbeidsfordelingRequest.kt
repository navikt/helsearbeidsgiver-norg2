package no.nav.helsearbeidsgiver.norg2

@kotlinx.serialization.Serializable
data class ArbeidsfordelingRequest(
    var behandlingstema: String? = null,
    var behandlingstype: String? = null,
    var diskresjonskode: String? = null,
    var enhetNummer: String? = null,
    var geografiskOmraade: String? = null,
    var oppgavetype: String? = null,
    var skjermet:	Boolean? = null,
    var tema: String? = null,
    var temagruppe: String? = null
)
