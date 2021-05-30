function completeQuest() {
    var questId = $('#questQuest').children("option:selected").attr('id-value');
    var userId = $("#questUser").children("option:selected").attr('id-value');
    tableId:
        hookahNumber: $('#hookahNum').val(),
            $.ajax({
                type: "POST",
                contentType: "application/json; charset=utf-8",
                url: "/api/quest/complete?userId=" + userId + "&questId=" + questId,
                success: function (completeQuest) {
                    if (completeQuest.error == null) {
                        alert('Квест успешно выполнен')
                    }
                }
            });
}

function deleteQuest() {
    var questId = $('#deleteQuestButton').attr('id-value');
    tableId:
        hookahNumber: $('#hookahNum').val(),
            $.ajax({
                type: "DELETE",
                contentType: "application/json; charset=utf-8",
                url: "/api/quest?questId=" + questId,
                success: function (deleteQuest) {
                    if (deleteQuest.error == null) {
                        alert('Квест успешно удален')
                    }
                }
            });
}

function createQuest() {
    var payload = {
        title: $('#questName').val(),
        description: $('#questDescription').val(),
        incrementValue: $('#questBonusValue').val(),
        mainAttribute: $("#questAttribute").children("option:selected").attr('id-value'),
    };
    $.ajax({
        type: "POST",
        contentType: "application/json; charset=utf-8",
        url: "/api/quest",
        data: JSON.stringify(payload),
        dataType: "json",
        success: function (questCreate) {
            if (questCreate.error == null) {
                alert('Квест успешно создан')
            }
        }
    });
}

function deleteAchievement() {

}

function createAchievement() {

}

function deleteUser() {

}

function createUser() {

}

function makeOrder() {
    var payload = {
        guestNumber: $('#guestNum').val(),
        hookahNumber: $('#hookahNum').val(),
        comment: $('#comment').val(),
        startFrom: getDate(),
        tableId: $("#tablesDropdown").children("option:selected").attr('id-value')
    };
    console.log(payload);
    $.ajax({
        type: "POST",
        contentType: "application/json; charset=utf-8",
        url: "/api/v0/order",
        data: JSON.stringify(payload),
        dataType: "json",
        success: function (freeTable) {
            if (freeTable.error == null) {
                console.log("debug success order, freeTable.data.id=" + freeTable.data.id);
                $('#notification').text("Столик забронирован: " + freeTable.data.table.description);
                $('#comment').text("");
                renderTableOrders();
            } else if (freeTable.error === 'TABLE_IS_BOOKED') {
                alert('Столик занят');
            } else if (freeTable.error === 'TABLE_IS_NOT_ENOUGH') {
                alert('За столиком недостаточно мест');
            }
        }
    });
}