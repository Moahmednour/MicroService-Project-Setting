using Microsoft.EntityFrameworkCore;
using NetService.Controllers;
using NetService.Service;
using NetService;
using Steeltoe.Discovery.Client;


var builder = WebApplication.CreateBuilder(args);
var configuration = builder.Configuration;


// Add services to the container.
var connectionString = builder.Configuration.GetConnectionString("DefaultConnection");
builder.Services.AddDbContext<ProductContext>(options =>
    options.UseSqlServer(connectionString));

// Learn more about configuring Swagger/OpenAPI at https://aka.ms/aspnetcore/swashbuckle
builder.Services.AddEndpointsApiExplorer();
builder.Services.AddSwaggerGen();

// Add ProductService to the container
builder.Services.AddScoped<ProductService>();
builder.Services.AddScoped<ProductController>();
builder.Services.AddControllers();

builder.Services.AddDiscoveryClient(builder.Configuration);

var app = builder.Build();

// Configure the HTTP request pipeline.
if (app.Environment.IsDevelopment())
{
    app.UseSwagger();
    app.UseSwaggerUI();
}

app.UseHttpsRedirection();
app.UseAuthorization();

app.MapControllers();
app.UseDiscoveryClient();

app.Run();
