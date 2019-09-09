/**
 * 
 */
$(document).ready(function() {
                $('#tableMedecin').dataTable({
                    oLanguage: {
                        sSearch: "Rechercher : ",
                        sZeroRecords: "Aucune valeur trouvee !!",
                        sLengthMenu: "Afficher: _MENU_ Medecin par page ",
                        sInfo: "Afficher page _PAGE_ of _PAGES_",
                        oPaginate: {
                            sFirst: "Premier",
                            sPrevious: "Precedent",
                            sNext: "Suivant",
                            sLast: "Dernier"
                        }

                    },
                    "pagingType": "full_numbers"
                });
            });


