function getPromoCoupons(idPromo) {
    $.ajax({
        type: "post",
        url: promoCouponsUrl,
        data: {
            "_token": csrfToken,
            'idOfferta': idPromo
        },
        error: function(data) {
            alert("Si è verificato un errore durante l'ottenimento dei dati: " + data.status);
        },
        success: function(data) {
            $("#promoCouponsNumber").text("Per la promo " + data.offerName + " sono stati emessi " + data.couponNumber + " coupons.");
        }
    });
}

function getClientiCoupons(usernameCliente) {
    $.ajax({
        type: "post",
        url: clienteCouponsUrl,
        data: {
            "_token": csrfToken,
            'username': usernameCliente
        },
        error: function(data) {
            alert("Si è verificato un errore durante l'ottenimento dei dati: " + data.status);
        },
        success: function(data) {
            $("#customerCouponsNumber").text("Per il cliente " + data.username + " sono stati emessi " + data.couponNumber + " coupons.");
        }
    });
}
