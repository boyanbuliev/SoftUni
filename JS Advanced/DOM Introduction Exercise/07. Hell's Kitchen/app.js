function solve() {
   document.querySelector('#btnSend').addEventListener('click', onClick);

   function onClick() {
      let arr = JSON.parse(document.querySelector('#inputs>textarea').value);

      let restaurants = {};

      arr.forEach(line => {
         let [restaurant, workers] = line.split(' - ');
         workers = workers.split(', ').map(worker => {
            let [name, salary] = worker.split(' ');
            return { name, salary: Number(salary) }
         })
         if (restaurants[restaurant]) {
            workers = workers.concat(restaurants[restaurant].workers);
         }
         workers.sort((w1, w2) => w2.salary - w1.salary);
         const averageSalary = workers.reduce((sum, worker) => sum + worker.salary, 0) / workers.length;
         const bestSalary = workers[0].salary;
         restaurants[restaurant] = { workers, averageSalary, bestSalary }
      })
      let bestRestaurant = undefined;
      for (const restaurant in restaurants) {
         if (!bestRestaurant || bestRestaurant.averageSalary < restaurants[restaurant].averageSalary) {
            bestRestaurant = { name: restaurant, ...restaurants[restaurant] };
         }
      }
      document.querySelector('#bestRestaurant>p').textContent =
         `Name: ${bestRestaurant.name} Average Salary: ${bestRestaurant.averageSalary.toFixed(2)} Best Salary: ${bestRestaurant.bestSalary.toFixed(2)}`
      document.querySelector('#workers>p').textContent = bestRestaurant.workers
         .map(w => `Name: ${w.name} With Salary: ${w.salary}`).join(' ')
   }
}