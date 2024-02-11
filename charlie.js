const ANSI_RESET = "\u001B[0m"
const ANSI_RED = "\u001B[31m"

class Direction {
    constructor(x, y) {
        this.X = x;
        this.Y = y;
    }
}

const HORIZONTAL = new Direction(1, 0);
const VERTICAL = new Direction(0, 1);
const DIAGONAL = new Direction(1, 1);

class Charlie {
    constructor(word, rows, columns, direction) {
        this.Word = word;
        this.Rows = rows;
        this.Columns = columns;
        this.Direction = direction;
        this.tableau = [];

        this.init();
        this.fill();
        this.fillWord();
    }

    init() {
        for (let i = 0; i < this.Rows; i++) {
            this.tableau[i] = new Array(this.Columns);
        }
    }

    fill() {
        for (let i = 0; i < this.Rows; i++) {
            for (let j = 0; j < this.Columns; j++) {
                this.tableau[i][j] = String.fromCharCode(Math.floor(Math.random() * 26) + 65);
            }
        }
    }

    fillWord() {
        let startRow = Math.floor(Math.random() * this.Rows);
        if (this.Direction.Y === 1) {
            startRow -= this.Word.length;
        }
        if (startRow < 0) {
            startRow = 0;
        }
        let startColumn = Math.floor(Math.random() * this.Columns);
        if (this.Direction.X === 1) {
            startColumn -= this.Word.length;
        }
        if (startColumn < 0) {
            startColumn = 0;
        }

        for (let i = 0; i < this.Word.length; i++) {
            this.tableau[startRow + (this.Direction.Y * i)][startColumn + (this.Direction.X * i)] = ANSI_RED + this.Word[i] + ANSI_RESET;
        }
    }

    print() {
        for (let i = 0; i < this.Rows; i++) {
            let row = '';
            for (let j = 0; j < this.Columns; j++) {
                row += this.tableau[i][j] + ' ';
            }
            console.log(row);
        }
        console.log('\n\n');
    }
}

let c1 = new Charlie("CHARLIE", 20, 20, HORIZONTAL);
c1.print();

let c2 = new Charlie("CHARLIE", 20, 20, DIAGONAL);
c2.print();

let c3 = new Charlie("CHARLIE", 20, 20, VERTICAL);
c3.print();