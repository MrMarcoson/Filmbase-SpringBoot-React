import { useEffect, useState } from "react"


const Grade = () => {
    const [grade, setGrade] = useState(0);
    const [showR, setShowR] = useState(false);

    const handleOptionChange = (event) => {
        setGrade(event.target.value)

        //clear stars
        for(let i = 1; i <= 10; i++) {
            document.getElementById("r"+i).className = "star";
        }

        //set them to value
        for(let i = 1; i <= event.target.value; i++) {
            document.getElementById("r"+i).className = "starChecked";
        }
    }

    const handleHover = (event) => {
        console.log("E")

        
    }

    return (
        <div class="stars">
            <form id="starsRadio">
                <input type="radio" name="radio" id="radio1" value={1} onClick={handleOptionChange}/>
                <label for="radio1"><span id="r1" class="star"></span></label>

                <input type="radio" name="radio" id="radio2" value={2} onChange={handleOptionChange}/>
                <label for="radio2"><span id="r2" class="star"></span></label>

                <input type="radio" name="radio" id="radio3" value={3} onChange={handleOptionChange}/>
                <label for="radio3"><span id="r3" class="star"></span></label>

                <input type="radio" name="radio" id="radio4" value={4} onChange={handleOptionChange}/>
                <label for="radio4"><span id="r4" class="star"></span></label>

                <input type="radio" name="radio" id="radio5" value={5} onChange={handleOptionChange}/>
                <label for="radio5"><span id="r5" class="star"></span></label>

                <input type="radio" name="radio" id="radio6" value={6} onClick={handleOptionChange}/>
                <label for="radio6"><span id="r6" class="star"></span></label>

                <input type="radio" name="radio" id="radio7" value={7} onChange={handleOptionChange}/>
                <label for="radio7"><span id="r7" class="star"></span></label>

                <input type="radio" name="radio" id="radio8" value={8} onChange={handleOptionChange}/>
                <label for="radio8"><span id="r8" class="star"></span></label>

                <input type="radio" name="radio" id="radio9" value={9} onChange={handleOptionChange}/>
                <label for="radio9"><span id="r9" class="star"></span></label>

                <input type="radio" name="radio" id="radio10" value={10} onChange={handleOptionChange}/>
                <label for="radio10"><span id="r10" class="star"></span></label>
            </form>
            <h3>Your grade: {grade}</h3>
        </div>
    )
}

export default Grade;