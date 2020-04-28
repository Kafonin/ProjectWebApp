const date_picker_element   = document.querySelector('.date-picker');
const selected_date_element = document.querySelector('.date-picker .selected-date');
const dates_element         = document.querySelector('.date-picker .dates');
const mth_element           = document.querySelector('.date-picker .dates .month .mth');
const next_mth_element      = document.querySelector('.date-picker .dates .month .next-mth');
const prev_mth_element      = document.querySelector('.date-picker .dates .month .prev-mth');
const days_element          = document.querySelector('.date-picker .dates .days');
const pop_up_form           = document.querySelector('.modal');
const exit_out              = document.querySelector('.modal .close');

const months = ['January', 'February', 'March', 'April', 'May', 'June', 'July', 'August', 'September', 'October', 'November', 'December'];

let date                            = new Date();
let day                             = date.getDate();
let month                           = date.getMonth();
let year                            = date.getFullYear();

let selectedDate                    = date;
let selectedDay                     = day;
let selectedMonth                   = month;
let selectedYear                    = year;

mth_element.textContent             = months[month] + ' ' + year;

selected_date_element.textContent   = formatDate(date);
selected_date_element.dataset.value = selectedDate;

populateDates();

// Event listeners to trigger the functions below
date_picker_element.addEventListener('click', toggleDatePicker);
prev_mth_element.addEventListener('click', goToPrevMonth);
next_mth_element.addEventListener('click', goToNextMonth);
days_element.addEventListener('click', revealModal);
exit_out.addEventListener('click', closeModal);


// Functions
function toggleDatePicker(events) {
    if (!checkEventPathForClass(events.path, 'dates')) {
        dates_element.classList.toggle('active');
    }
}

function goToNextMonth(events) {
    month++;
    if (month > 11) {
        month = 0;
        year++;
    }
    mth_element.textContent = months[month] + ' ' + year;
    populateDates();
}

function goToPrevMonth(events) {
    month--;
    if (month < 0) {
        month = 11;
        year--;
    }
    mth_element.textContent = months[month] + ' ' + year;
    populateDates();
}

function populateDates(events) {
    days_element.innerHTML = '';

    let amount_days = 31;

    if (month == 1) {
        amount_days = 29;
    }
    if (month == 3 || month == 5 || month == 8 || month == 10) {
        amount_days = 30;
    }

    for (let i = 0; i < amount_days; i++) {
        const day_element       = document.createElement('div');    
        day_element.classList.add('day');
        day_element.textContent = i+1;

        if (selectedDay == (i+1) && selectedYear == year && selectedMonth == month) {
            day_element.classList.add('selected');
        }

        day_element.addEventListener('click', function () {
            selectedDate                        = new Date(year + '-' + (month+1) + '-' + (i+1));
            selectedDay                         = (i + 1);
            selectedMonth                       = month;
            selectedYear                        = year;
            selected_date_element.textContent   = formatDate(selectedDate);
            selected_date_element.dataset.value = selectedDate;

            populateDates();
        });

        days_element.appendChild(day_element);
    }
}

// Helper Functions
function checkEventPathForClass(path, selector) {
    for (let i = 0; i < path.length; i++) {
        if(path[i].classList && path[i].classList.contains(selector)) {
            return true;
        }
    }
    return false;
}
function formatDate(d) {
    let day = d.getDate();
    if (day < 10) {
        day = '0' + day;
    }

    let month = d.getMonth() + 1;
    if (day < 10) {
        day = '0' + month;
    }

    let year = d.getFullYear();

    return month + ' / ' + day + ' / ' + year;
}

////////////////////////////////////
////////////POP UP FORM/////////////
////////////////////////////////////

// Begin Modal

// Function responsible to open the modal
function revealModal(events) {
    if (!checkEventPathForClass(events.path, 'modal')) {
        pop_up_form.style.display = "block";
    }
}

// Function responsible to close the modal
function closeModal(events) {
    if (!checkEventPathForClass(events.path, 'modal .close')) {
        pop_up_form.style.display = "none";
    }
}